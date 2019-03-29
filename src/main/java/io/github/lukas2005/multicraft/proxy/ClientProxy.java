package io.github.lukas2005.multicraft.proxy;

import io.github.lukas2005.multicraft.EnumColor;
import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockColoredPlanks;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
        new ResourceLocation(item.getRegistryName().getNamespace(), item.getRegistryName().getPath() + "suffix");
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));

        if(id == "colored_planks") {
            for (EnumDyeColor color : EnumDyeColor.values()) {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 1, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 2, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 3, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 4, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 5, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 6, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 7, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 8, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 9, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 10, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 11, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 12, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 13, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 14, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
                ModelLoader.setCustomModelResourceLocation(item, 15, new ModelResourceLocation(Main.MODID + ":" + color.getName() + "_" + id, "inventory"));
            }
        }

    }

    /* old code #NOKEEP #NEEDSMOVE
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
        if (block instanceof BlockColoredPlanks) {
            for (EnumColor color : EnumColor.values()) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), color.getMetadata(), new ModelResourceLocation(block.getRegistryName(), "color="+color.getName()));
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
    */
}
