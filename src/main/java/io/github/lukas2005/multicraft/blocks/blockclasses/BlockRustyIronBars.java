package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.blocks.BlockPaneBase;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRustyIronBars extends BlockPaneBase {
    public BlockRustyIronBars() {
        super(Material.IRON, "rusty_iron_bars", CreativeTabs.DECORATIONS);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(ModItems.RUST_DUST, 6));
        drops.add(new ItemStack(Items.IRON_NUGGET, 3));
    }
}
