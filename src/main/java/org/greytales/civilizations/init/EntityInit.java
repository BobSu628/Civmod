package org.greytales.civilizations.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.entity.EntityTestVillager;
import org.greytales.civilizations.util.Reference;

public class EntityInit {

    public static void registerEntities(){
        registerEntity("testvillager", EntityTestVillager.class, Reference.ENTITY_TESTVILLAGER, 50, 11437146, 0);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID+":"+name), entity, name, id, CivilizationsMod.instance, range, 1, true, color1, color2);
    }
}
