package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import java.util.Random;

// #UNUSED
class BlockFallingSnowBlock extends BlockFalling {
    protected BlockFallingSnowBlock() {
        super(Material.CRAFTED_SNOW);
        setTickRandomly(true);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("falling_snow_block");
        setUnlocalizedName(Main.MODID + "." + "falling_snow_block");
    }

    /**
     * @return the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.SNOWBALL;
    }

    /**
     * @return the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random) {
        return 4;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11)
        {
            this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
            worldIn.setBlockToAir(pos);
        }
    }
}