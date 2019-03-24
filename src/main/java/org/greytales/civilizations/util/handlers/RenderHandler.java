package org.greytales.civilizations.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.greytales.civilizations.entity.EntityTestVillager;
import org.greytales.civilizations.entity.render.RenderTestVillager;

public class RenderHandler {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityTestVillager.class, new IRenderFactory<EntityTestVillager>() {
            @Override
            public Render<? super EntityTestVillager> createRenderFor(RenderManager manager) {
                return new RenderTestVillager(manager);
            }
        });
    }

}
