package org.greytales.civilizations.init;

import net.minecraftforge.fml.common.registry.VillagerRegistry;
import org.greytales.civilizations.world.gen.structure.LandmarkCreationHandler;

public class VillageInit {

    public static void registerVillageCreationHandler(LandmarkCreationHandler l){
        VillagerRegistry.instance().registerVillageCreationHandler(l);
    }

}
