package io.github.lukas2005.multicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

class BlockAncientStone extends Block {
    public BlockAncientStone() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
