package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.items.ItemBase;
import io.github.lukas2005.multicraft.utils.Utils;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ItemWitherBoneMeal extends ItemBase {
    public ItemWitherBoneMeal() {
        super("wither_bone_meal", CreativeTabs.MATERIALS);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState state = worldIn.getBlockState(pos);
        ItemStack is = player.getHeldItem(hand);

        if (state.getBlock() == Blocks.NETHER_WART) {
            int age = state.getValue(BlockNetherWart.AGE);

            if (age+1 <= 3) {
                IBlockState newState = Blocks.NETHER_WART.getDefaultState().withProperty(BlockNetherWart.AGE, age+1);
                worldIn.setBlockState(pos, newState);

                if (!worldIn.isRemote){
                    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                    Utils.sendCommand(server, server, "/particle fallingdust ~ ~ ~ 0.5 0.5 0.5 0.5 20 0.5 @a", false, pos);
                }

                is.setCount(is.getCount()-1);
                return EnumActionResult.SUCCESS;
            }
        } else if (state.getBlock() == Blocks.POTATOES) {
            worldIn.setBlockToAir(pos);
            if (!worldIn.isRemote && state.getValue(BlockCrops.AGE)+1==8) player.dropItem(Items.POISONOUS_POTATO, 1);
        }
        return EnumActionResult.FAIL;
    }
}