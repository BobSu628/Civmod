package org.greytales.civilizations.world.gen.structure;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MapGenCivVillage extends MapGenStructure {

    private int size;
    private int distance;

    public static List<Biome> VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList(Biomes.PLAINS, Biomes.DESERT, Biomes.SAVANNA, Biomes.TAIGA);

    public MapGenCivVillage() {
        this.distance = 12;

    }

    public MapGenCivVillage(Map<String, String> map){
        this();

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if ((entry.getKey()).equals("size"))
            {
                this.size = MathHelper.getInt(entry.getValue(), this.size, 0);
            }
            else if (((String)entry.getKey()).equals("distance"))
            {
                this.distance = MathHelper.getInt(entry.getValue(), this.distance, 9);
            }
        }
    }

    @Override
    public String getStructureName() {
        return "Civmod Village";
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
        this.world = worldIn;
        return findNearestStructurePosBySpacing(worldIn, this, pos, this.distance, 8, 10387312, false, 100, findUnexplored);
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int i = chunkX;
        int j = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.distance - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= this.distance - 1;
        }

        int k = chunkX / this.distance;
        int l = chunkZ / this.distance;

        // randomize relative positions of village candidate sites
        Random random = this.world.setRandomSeed(k, l, 10387312);
        k = k * this.distance;
        l = l * this.distance;
        k = k + random.nextInt(this.distance - 8);
        l = l + random.nextInt(this.distance - 8);

        if (i == k && j == l)
        {
            boolean flag = this.world.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 0, VILLAGE_SPAWN_BIOMES);

            if (flag)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        return new MapGenCivVillage.Start(this.world, this.rand, chunkX, chunkZ, this.size);
    }

    public static class Start extends StructureStart
    {
        /** well ... thats what it does */
        private boolean hasMoreThanTwoComponents;

        public Start() { }

        public Start(World worldIn, Random rand, int x, int z, int size)
        {
            super(x, z);
            List<StructureVillagePieces.PieceWeight> list = StructureVillagePieces.getStructureVillageWeightedPieceList(rand, size);
            StructureVillagePieces.Start start = new StructureVillagePieces.Start(worldIn.getBiomeProvider(), 0, rand, (x << 4) + 2, (z << 4) + 2, list, size);
            components.add(start);
            start.buildComponent(start, components, rand);
            List<StructureComponent> pendingRoads = start.pendingRoads;
            List<StructureComponent> pendingHouses = start.pendingHouses;

            while (!pendingRoads.isEmpty() || !pendingHouses.isEmpty())
            {
                if (pendingRoads.isEmpty())
                {
                    int i = rand.nextInt(pendingHouses.size());
                    StructureComponent component = pendingHouses.remove(i);
                    component.buildComponent(start, components, rand);
                }
                else
                {
                    int j = rand.nextInt(pendingRoads.size());
                    StructureComponent component = pendingRoads.remove(j);
                    component.buildComponent(start, components, rand);
                }
            }

            updateBoundingBox();
            int nonRoadComponentCount = 0;

            for (StructureComponent component : components)
            {
                if (!(component instanceof StructureVillagePieces.Road))
                {
                    ++nonRoadComponentCount;
                }
            }

            hasMoreThanTwoComponents = nonRoadComponentCount > 2;
        }

        /**
         * currently only defined for Villages, returns true if Village has more than 2 non-road components.
         *
         * @return true, if is sizeable structure
         */
        @Override
        public boolean isSizeableStructure()
        {
            return hasMoreThanTwoComponents;
        }

        /* (non-Javadoc)
         * @see net.minecraft.world.gen.structure.StructureStart#writeToNBT(net.minecraft.nbt.NBTTagCompound)
         */
        @Override
        public void writeToNBT(NBTTagCompound tagCompound)
        {
            super.writeToNBT(tagCompound);
            tagCompound.setBoolean("Valid", hasMoreThanTwoComponents);
        }

        /* (non-Javadoc)
         * @see net.minecraft.world.gen.structure.StructureStart#readFromNBT(net.minecraft.nbt.NBTTagCompound)
         */
        @Override
        public void readFromNBT(NBTTagCompound tagCompound)
        {
            super.readFromNBT(tagCompound);
            hasMoreThanTwoComponents = tagCompound.getBoolean("Valid");
        }
    }


}
