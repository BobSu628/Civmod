package org.greytales.civilizations;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import org.greytales.civilizations.proxy.CommonProxy;
import org.greytales.civilizations.tabs.CivTab;
import org.greytales.civilizations.util.Reference;
import org.greytales.civilizations.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class CivilizationsMod
{
    @Mod.Instance
    public static CivilizationsMod instance;

    //public static final CivCreativeTabs civtab = new CivTab("civtab");

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        RegistryHandler.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.init();
        // some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){}
}
