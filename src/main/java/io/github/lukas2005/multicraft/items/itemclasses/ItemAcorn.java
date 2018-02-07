package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.items.ItemBase;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;

public class ItemAcorn extends ItemBase {
    private static ArrayList<Block> hardBlocks = new ArrayList<>();

    public ItemAcorn() {
        super("acorn", CreativeTabs.MISC);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        initHardBlocks();

        if(hardBlocks.contains(worldIn.getBlockState(pos).getBlock()) && facing == EnumFacing.UP) {
            if(hand == EnumHand.MAIN_HAND) {
                int amount = player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getCount();
                ItemStack newStack = new ItemStack(ModItems.ACORN, amount - 1);
                player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, newStack);
                ItemStack splitAcornStack = new ItemStack(ModItems.SPLIT_ACORN, 1);
                ItemHandlerHelper.giveItemToPlayer(player, splitAcornStack);
            } else {
                int amount = player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND).getCount();
                ItemStack newStack = new ItemStack(ModItems.ACORN, amount - 1);
                player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, newStack);
                ItemStack splitAcornStack = new ItemStack(ModItems.SPLIT_ACORN, 1);
                ItemHandlerHelper.giveItemToPlayer(player, splitAcornStack);
            }
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.PASS;
        }
    }

    private static void initHardBlocks() {
        hardBlocks.clear();

        hardBlocks.add(Blocks.ANVIL);
        hardBlocks.add(Blocks.BEDROCK);
        hardBlocks.add(Blocks.OBSIDIAN);
        hardBlocks.add(Blocks.STONE);
    }
}
