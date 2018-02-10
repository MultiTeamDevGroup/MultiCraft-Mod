package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStairsBase extends BlockStairs {
    protected String name;

    public BlockStairsBase(IBlockState modelState, String name, CreativeTabs tab) {
        super(modelState);
        setRegistryName(name);
        setUnlocalizedName(Main.MODID + "." + name);
        setCreativeTab(tab);
        this.name = name;
    }

    public void registerItemModel(Item itemBlock) {
        Main.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    /**
     * @return whether the block is a solid cube or not. Override for blocks that are not solid cubes.
     */
    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }
}
