package io.github.lukas2005.multicraft.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static io.github.lukas2005.multicraft.blocks.ModBlocks.COLORED_PLANKS;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        //COLORED_PLANKS.registerItemModel(item);
    }
}
