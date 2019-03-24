package org.greytales.civilizations.world.gen;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.greytales.civilizations.init.BlockInit;
import org.greytales.civilizations.objects.blocks.BlockOres;
import org.greytales.civilizations.util.handlers.EnumHandler;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator {

    private WorldGenerator ore_magium, ore_dimmium;

    public WorldGenCustomOres(){
        ore_magium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.MAGIUM), 9, BlockMatcher.forBlock(Blocks.STONE));
        ore_dimmium = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.DIMMIUM), 9, BlockMatcher.forBlock(Blocks.STONE));
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight){
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bound");

        int heightDiff = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i ++){
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            //System.out.println("Start generating custom ores");
            gen.generate(world, rand, new BlockPos(x,y,z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0) {
            runGenerator(ore_magium, world, random, chunkX, chunkZ, 50, 0, 100);
            runGenerator(ore_dimmium, world, random, chunkX, chunkZ, 50, 0, 100);
        }
    }
}
