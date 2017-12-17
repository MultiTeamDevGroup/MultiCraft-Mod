package io.github.lukas2005.multicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;

public class BlockBase extends Block {

    ArrayList<ItemStack> drops = new ArrayList<>();

    public BlockBase(Material blockMaterialIn, boolean dropsItself) {
        super(blockMaterialIn);
        if (dropsItself) drops.add(new ItemStack(this));
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        super.getDrops(drops, world, pos, state, fortune);
        drops.addAll(this.drops);
    }

    public BlockBase addDrop(ItemStack stack) {
        drops.add(stack);
        return this;
    }
}
