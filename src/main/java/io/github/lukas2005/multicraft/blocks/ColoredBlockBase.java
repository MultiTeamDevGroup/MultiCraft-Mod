package io.github.lukas2005.multicraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;

public class ColoredBlockBase extends BlockBase {

    public ColoredBlockBase(Material material, String name, Float hardness, CreativeTabs tab) {
        super(material, name, hardness, tab);
    }

    public Item createItemBlock() {
        return new ItemCloth(this).setRegistryName(getRegistryName());
    }

}
