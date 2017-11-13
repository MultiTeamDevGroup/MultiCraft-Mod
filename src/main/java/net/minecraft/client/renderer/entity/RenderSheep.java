package net.minecraft.client.renderer.entity;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class RenderSheep extends RenderLiving<EntitySheep>
{
    private static final HashMap<EnumDyeColor, ResourceLocation> SHEARED_SHEEP_TEXTURES = new HashMap<>();

    public RenderSheep(RenderManager p_i47195_1_)
    {
        super(p_i47195_1_, new ModelSheep2(), 0.7F);
        this.addLayer(new LayerSheepWool(this));
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySheep entity)
    {
        return SHEARED_SHEEP_TEXTURES.get(entity.getFleeceColor());
    }

    static {
        SHEARED_SHEEP_TEXTURES.put(EnumDyeColor.WHITE, new ResourceLocation("textures/entity/sheep/sheep.png"));
        for (EnumDyeColor color : EnumDyeColor.values()) {
            if (color != EnumDyeColor.WHITE) {
                SHEARED_SHEEP_TEXTURES.put(color, new ResourceLocation(Reference.MOD_ID,"textures/entity/sheep/sheep_"+color.getDyeColorName()+".png"));
            }
        }
    }

}