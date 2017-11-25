package io.github.lukas2005.multicraft.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("EmptyMethod")
public interface IProxy {

    void preInit(FMLPreInitializationEvent e);

    @SuppressWarnings("EmptyMethod")
    void init(FMLInitializationEvent e);

    void postInit(FMLPostInitializationEvent e);

    void registerItemRender(Item item);
    void registerBlockRender(Block block);
}
