package io.github.lukas2005.multicraft.proxy;

import io.github.lukas2005.multicraft.EnumColor;
import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.blocks.ColoredPlanks;
import io.github.lukas2005.multicraft.entity.render.CustomRenderSheep;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy {

    public static final KeyBinding KEY_PORTABLE_FURNANCE = new KeyBinding("keybind."+Reference.MOD_ID+".portable_furnance_key", Keyboard.KEY_C, "key.categories.inventory");

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(EntitySheep.class, new CustomRenderSheep.Factory());
    }

    @Override
    public void init(FMLInitializationEvent e) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    @Override
    public void registerItemRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void registerBlockRender(Block block) {
        if (block instanceof ColoredPlanks) {
            for (EnumColor color : EnumColor.values()) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), color.getMetadata(), new ModelResourceLocation(block.getRegistryName(), "color="+color.getName()));
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
}
