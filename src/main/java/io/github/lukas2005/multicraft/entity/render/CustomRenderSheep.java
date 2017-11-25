package io.github.lukas2005.multicraft.entity.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CustomRenderSheep extends RenderSheep {

    private CustomRenderSheep(RenderManager p_i47195_1_) {
        super(p_i47195_1_);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySheep entity) {
        EnumDyeColor color = entity.getFleeceColor();

        return color == EnumDyeColor.WHITE ? new ResourceLocation("textures/entity/sheep/sheep.png") : new ResourceLocation("textures/entity/sheep/sheep_"+color.getDyeColorName()+".png");
    }

    public static class Factory implements IRenderFactory<EntitySheep> {

        @Override
        public Render<? super EntitySheep> createRenderFor(RenderManager manager) {
            return new CustomRenderSheep(manager);
        }

    }

}
