package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;

public class ModItems {

    public static final HashMap<String, Item> ModItems = new HashMap<>();

    public static void init() {
        // Food
        registerItem(new RawParrotMeatItem(), "raw_parrot_meat");
        registerItem(new CookedParrotMeatItem(), "cooked_parrot_meat");

        // Materials
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "llama_fur");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "bat_wing");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "ender_pearl_piece");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "chain");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "polar_bear_leather");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "silver_fish_scale");

        registerItem(new Item() {
            @Override
            public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
                IBlockState state = worldIn.getBlockState(pos);
                ItemStack is = player.getHeldItem(hand);

                if (state.getBlock() == Blocks.NETHER_WART) {
                    int age = state.getValue(BlockNetherWart.AGE);

                    if (age+1 <= 3) {
                        IBlockState newState = Blocks.NETHER_WART.getDefaultState().withProperty(BlockNetherWart.AGE, age+1);
                        worldIn.setBlockState(pos, newState);

                        if (!worldIn.isRemote) ItemDye.spawnBonemealParticles(worldIn, pos, 10);

                        is.setCount(is.getCount()-1);
                        return EnumActionResult.SUCCESS;
                    }
                } else if (state.getBlock() == Blocks.POTATOES) {
                    worldIn.setBlockToAir(pos);
                    if (!worldIn.isRemote && state.getValue(BlockCrops.AGE)+1==8) player.dropItem(Items.POISONOUS_POTATO, 1);
                }
                return EnumActionResult.FAIL;
            }
        }.setCreativeTab(CreativeTabs.MATERIALS), "wither_bone_meal");

        // Armor
        registerItem(new FurCostumeArmor.FurCostumeHelmet(), "fur_costume_helmet");
        registerItem(new FurCostumeArmor.FurCostumeChestplate(), "fur_costume_chestplate");
        registerItem(new FurCostumeArmor.FurCostumeLeggings(), "fur_costume_leggings");
        registerItem(new FurCostumeArmor.FurCostumeBoots(), "fur_costume_boots");

        // Weapon
        registerItem(new Hammer(), "hammer");

        // Shield
        registerItem(new CustomShield(400), "iron_shield");
        registerItem(new CustomShield(500), "golden_shield");
        registerItem(new CustomShield(700), "diamond_shield");
    }

    private static void registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        item.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModItems.put(item.getUnlocalizedName(), item);
    }

    public static Item getItem(String itemName) {
        return ModItems.get("item."+Reference.MOD_ID+"."+itemName);
    }
}
