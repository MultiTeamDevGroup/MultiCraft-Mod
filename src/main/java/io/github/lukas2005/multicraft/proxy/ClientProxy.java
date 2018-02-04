package io.github.lukas2005.multicraft.proxy;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Main.MODID + ":" + id, "inventory"));
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
