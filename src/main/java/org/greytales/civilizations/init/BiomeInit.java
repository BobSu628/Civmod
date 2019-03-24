package org.greytales.civilizations.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.greytales.civilizations.world.biomes.BiomeMagicCircle;

public class BiomeInit {

    public static final Biome MAGIC_CIRCLE = new BiomeMagicCircle();

    public static void registerBiomes(){
        initBiome(MAGIC_CIRCLE, "Magic_Circle", BiomeType.COOL, Type.MAGICAL, Type.SPOOKY);
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types){
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println("Biome Registered");
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        System.out.println("Biome Added");
        return biome;
    }

}
