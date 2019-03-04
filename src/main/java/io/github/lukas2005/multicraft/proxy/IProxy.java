package io.github.lukas2005.multicraft.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {

    public void preInit(FMLPreInitializationEvent e);

    public void init(FMLInitializationEvent e);

    public void postInit(FMLPostInitializationEvent e);

    public void registerItemRender(Item item);
    public void registerBlockRender(Block block);
}
