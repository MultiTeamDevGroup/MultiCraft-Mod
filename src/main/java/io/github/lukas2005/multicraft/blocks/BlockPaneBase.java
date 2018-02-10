package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;

public class BlockPaneBase extends BlockPane {
    protected String name;

    public BlockPaneBase(Material material, String name, CreativeTabs tab) {
        super(material, true);
        setRegistryName(name);
        setUnlocalizedName(Main.MODID + name);
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
