package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.blocks.OreBase;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class RubyOre extends OreBase {

    public RubyOre() {
        super(Material.ROCK, "ruby_ore", 3.0f, Main.tab);
        setHarvestLevel("pickaxe", 2);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.RUBY;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }
}
