package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.armor.FurCostumeArmor;
import io.github.lukas2005.multicraft.armor.PolarBearHood;
import io.github.lukas2005.multicraft.armor.PortableFurnace;
import io.github.lukas2005.multicraft.items.food.CheeseItem;
import io.github.lukas2005.multicraft.items.food.CookedParrotMeatItem;
import io.github.lukas2005.multicraft.items.food.RawParrotMeatItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.HashMap;

public class ModItems {

    public static final HashMap<String, Item> ModItems = new HashMap<>();

    public static void init() {
        // Food
        registerItem(new RawParrotMeatItem(), "raw_parrot_meat");
        registerItem(new CookedParrotMeatItem(), "cooked_parrot_meat");
        registerItem(new CheeseItem().setCreativeTab(CreativeTabs.FOOD), "cheese");

        // Materials
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "llama_fur");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "bat_wing");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "ender_pearl_piece");
        registerItem(new ChainItem().setCreativeTab(CreativeTabs.MATERIALS), "chain");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "polar_bear_leather");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "silver_fish_scale");
        registerItem(new WitherBoneMeal().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone_meal");
        registerItem(new ItemAdobeBrick().setCreativeTab(CreativeTabs.MATERIALS), "adobe_brick");
        registerItem(new ItemFood(1, false) {
            @Override
            protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
                super.onFoodEaten(stack, worldIn, player);
                player.addExperienceLevel(8);
            }
        }, "emerald_apple");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "rust_dust");

        // Armor
        new FurCostumeArmor(); // It auto-registers itself now :P
        new PortableFurnace();
        new PolarBearHood();

        // Weapon
        registerItem(new Hammer(), "hammer");

        // Shield
        registerItem(new CustomShield(400), "iron_shield");
        registerItem(new CustomShield(500), "golden_shield");
        registerItem(new CustomShield(700), "diamond_shield");
    }

    public static Item registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        item.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModItems.put(item.getUnlocalizedName(), item);
        return item;
    }

    public static Item getItem(String itemName) {
        return ModItems.get("item."+Reference.MOD_ID+"."+itemName);
    }
}
