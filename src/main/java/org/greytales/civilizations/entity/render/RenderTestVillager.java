package org.greytales.civilizations.entity.render;

import net.minecraft.client.model.ModelIllager;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import org.greytales.civilizations.entity.EntityTestVillager;
import org.greytales.civilizations.entity.model.ModelCivVillager;
import org.greytales.civilizations.util.Reference;

public class RenderTestVillager extends RenderBiped<EntityTestVillager> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID, "textures/entity/testvillager.png");

    public RenderTestVillager(RenderManager manager){
        super(manager, new ModelCivVillager(), 0.5F);
        this.addLayer(new LayerBipedArmor(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTestVillager entity){
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityTestVillager entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
