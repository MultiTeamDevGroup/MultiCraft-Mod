package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAdobeBrick extends BlockBase {
    public BlockAdobeBrick() {
        super(Material.ROCK, "block_adobe_brick", 2, 9f, CreativeTabs.BUILDING_BLOCKS);
    }
}
