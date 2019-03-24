package org.greytales.civilizations.world.biomes;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import org.greytales.civilizations.init.BlockInit;
import org.greytales.civilizations.objects.blocks.BlockOres;
import org.greytales.civilizations.util.handlers.EnumHandler;

public class BiomeMagicCircle extends Biome {

    public BiomeMagicCircle(){
        super(new BiomeProperties("Magic_Circle")
                .setBaseHeight(0.125f)
                .setHeightVariation(0.05f)
                .setTemperature(0.7f)
                .setRainfall(0.3f)
                .setWaterColor(9896163));

        topBlock = Blocks.GLASS.getDefaultState();
        fillerBlock = Blocks.PRISMARINE.getDefaultState();

        this.decorator.coalGen = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.MAGIUM), 10);
        this.decorator.treesPerChunk = 0;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBlaze.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGuardian.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySpellcasterIllager.class, 7, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityIllusionIllager.class, 7, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 5, 1, 1));
    }

}
