package io.github.lukas2005.multicraft.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;

public class BlockPaneBase extends BlockPane {
    public BlockPaneBase(Material material, String name, CreativeTabs tab) {
        super(material, true);
    }
}
