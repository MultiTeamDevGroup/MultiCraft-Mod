package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockDoorBase extends BlockDoor {
    protected String name;

    public BlockDoorBase(Material material, String name, CreativeTabs tab) {
        super(material);

        this.name = name;
        super.setCreativeTab(tab);

        setTranslationKey(Main.MODID + "." + name);
        setRegistryName(name);
    }

    public void registerItemModel(Item itemBlock) {
        Main.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
