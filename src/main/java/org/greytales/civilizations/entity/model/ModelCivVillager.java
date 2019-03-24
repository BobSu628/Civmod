package org.greytales.civilizations.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - GreyTales
 * Created using Tabula 7.0.0
 */
public class ModelCivVillager extends ModelBase {
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedBodyWear;
    public ModelRenderer bipedLeftLegwear;
    public ModelRenderer bipedRightLegwear;
    public ModelRenderer bipedDeadmau5Head;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedRightArmwear;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedLeftArmwear;
    public ModelRenderer bipedCape;
    public ModelRenderer villagerHead;
    public ModelRenderer villagerHeadChild;

    public ModelCivVillager() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.villagerHeadChild = new ModelRenderer(this, 24, 0);
        this.villagerHeadChild.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.villagerHeadChild.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 0.0F);
        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
        this.bipedDeadmau5Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedDeadmau5Head.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
        this.bipedRightArmwear.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear.addBox(-4.0F, -10.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
        this.bipedLeftLegwear.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.villagerHead = new ModelRenderer(this, 0, 0);
        this.villagerHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.villagerHead.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
        this.bipedLeftArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 32, 48);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
        this.bipedRightLegwear.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.villagerHead.addChild(this.villagerHeadChild);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.bipedCape.render(f5);
        this.bipedBodyWear.render(f5);
        this.bipedDeadmau5Head.render(f5);
        this.bipedRightArmwear.render(f5);
        this.bipedLeftLeg.render(f5);
        this.bipedHeadwear.render(f5);
        this.bipedLeftLegwear.render(f5);
        this.villagerHead.render(f5);
        this.bipedLeftArmwear.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedBody.render(f5);
        this.bipedRightLeg.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedRightLegwear.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
