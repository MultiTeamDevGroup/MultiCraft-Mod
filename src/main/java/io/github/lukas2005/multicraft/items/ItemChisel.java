package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemChisel extends Item {
    /* #FIXLATER
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (ModBlocks.chiselMapping.containsKey(worldIn.getBlockState(pos))) {
            if (worldIn.setBlockState(pos, ModBlocks.chiselMapping.get(worldIn.getBlockState(pos)))) {
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    } */
}
