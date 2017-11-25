// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package io.github.lukas2005.multicraft.armor.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PortableFurnanceModel extends ModelBiped {
    //fields
    private ModelRenderer lead1;
    private ModelRenderer furnace;
    private ModelRenderer lead2;
    private ModelRenderer lead3;
    private ModelRenderer lead4;
    private ModelRenderer lead5;
    private ModelRenderer lead6;
    private ModelRenderer lead7;
    private ModelRenderer lead8;

    public PortableFurnanceModel(float scale) {
        super(scale, 0, 64, 54);
        textureWidth = 128;
        textureHeight = 128;

        lead1 = new ModelRenderer(this, 0, 43);
        lead1.addBox(3F, -0.5F, 2F, 1, 1, 4);
        lead1.setRotationPoint(0F, 0F, 0F);
        lead1.setTextureSize(128, 128);
        lead1.mirror = true;
        setRotation(lead1, -0.3658036F, 0F, 0F);
        furnace = new ModelRenderer(this, 0, 32);
        furnace.addBox(-4F, 2F, 2F, 8, 7, 4);
        furnace.setRotationPoint(0F, 0F, 0F);
        furnace.setTextureSize(128, 128);
        furnace.mirror = true;
        setRotation(furnace, 0F, 0F, 0F);
        lead2 = new ModelRenderer(this, 0, 43);
        lead2.addBox(-4F, -0.5F, 2F, 1, 1, 4);
        lead2.setRotationPoint(0F, 0F, 0F);
        lead2.setTextureSize(128, 128);
        lead2.mirror = true;
        setRotation(lead2, -0.3658036F, 0F, 0F);
        lead3 = new ModelRenderer(this, 0, 43);
        lead3.addBox(-4F, 1.6F, 5.5F, 1, 8, 1);
        lead3.setRotationPoint(0F, 0F, 0F);
        lead3.setTextureSize(128, 128);
        lead3.mirror = true;
        setRotation(lead3, 0F, 0F, 0F);
        lead4 = new ModelRenderer(this, 0, 43);
        lead4.addBox(3F, 1.6F, 5.5F, 1, 8, 1);
        lead4.setRotationPoint(0F, 0F, 0F);
        lead4.setTextureSize(128, 128);
        lead4.mirror = true;
        setRotation(lead4, 0F, 0F, 0F);
        lead5 = new ModelRenderer(this, 0, 43);
        lead5.addBox(3F, 9.9F, -1.9F, 1, 1, 4);
        lead5.setRotationPoint(0F, 0F, 0F);
        lead5.setTextureSize(128, 128);
        lead5.mirror = true;
        setRotation(lead5, 0.3658036F, 0F, 0F);
        lead6 = new ModelRenderer(this, 0, 43);
        lead6.addBox(-4F, 9.9F, -1.9F, 1, 1, 4);
        lead6.setRotationPoint(0F, 0F, 0F);
        lead6.setTextureSize(128, 128);
        lead6.mirror = true;
        setRotation(lead6, 0.3658036F, 0F, 0F);
        lead7 = new ModelRenderer(this, 0, 43);
        lead7.addBox(-4F, 0.5F, -3F, 1, 11, 1);
        lead7.setRotationPoint(0F, 0F, 0F);
        lead7.setTextureSize(128, 128);
        lead7.mirror = true;
        setRotation(lead7, 0F, 0F, 0F);
        lead8 = new ModelRenderer(this, 0, 43);
        lead8.addBox(3F, 0.5F, -3F, 1, 11, 1);
        lead8.setRotationPoint(0F, 0F, 0F);
        lead8.setTextureSize(128, 128);
        lead8.mirror = true;
        setRotation(lead8, 0F, 0F, 0F);

        bipedBody.addChild(lead1);
        bipedBody.addChild(lead2);
        bipedBody.addChild(lead3);
        bipedBody.addChild(lead4);
        bipedBody.addChild(lead5);
        bipedBody.addChild(lead6);
        bipedBody.addChild(lead7);
        bipedBody.addChild(lead8);
        bipedBody.addChild(furnace);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        lead1.render(f5);
        furnace.render(f5);
        lead2.render(f5);
        lead3.render(f5);
        lead4.render(f5);
        lead5.render(f5);
        lead6.render(f5);
        lead7.render(f5);
        lead8.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}