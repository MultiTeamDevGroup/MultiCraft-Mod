package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.items.itemclasses.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    // FOODS
    public static final ItemCheese CHEESE = new ItemCheese();
    public static final ItemRawParrotMeat RAW_PARROT_MEAT = new ItemRawParrotMeat();
    public static final ItemCookedParrotMeat COOKED_PARROT_MEAT = new ItemCookedParrotMeat();

    // BASIC MATERIALS
    public static final ItemAdobeBrick ADOBE_BRICK = new ItemAdobeBrick();
    public static final ItemBatWing BAT_WING = new ItemBatWing();
    public static final ItemEnderPearlPiece ENDER_PEARL_PIECE = new ItemEnderPearlPiece();
    public static final ItemLlamaFur LLAMA_FUR = new ItemLlamaFur();
    public static final ItemPolarBearLeather POLAR_BEAR_LEATHER = new ItemPolarBearLeather();
    public static final ItemSilverfishScale SILVERFISH_SCALE = new ItemSilverfishScale();
    public static final ItemWitherBone WITHER_BONE = new ItemWitherBone();

    // VARIOUS THINGS - #RENAMETHIS
    public static final ItemChain CHAIN = new ItemChain();
    public static final ItemWitherBoneMeal WITHER_BONE_MEAL = new ItemWitherBoneMeal();

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                CHEESE,
                RAW_PARROT_MEAT,
                COOKED_PARROT_MEAT,
                ADOBE_BRICK,
                BAT_WING,
                ENDER_PEARL_PIECE,
                LLAMA_FUR,
                POLAR_BEAR_LEATHER,
                SILVERFISH_SCALE,
                WITHER_BONE,
                CHAIN,
                WITHER_BONE_MEAL
        );
    }

    public static void registerModels() {
        CHEESE.registerItemModel();
        RAW_PARROT_MEAT.registerItemModel();
        COOKED_PARROT_MEAT.registerItemModel();

        ADOBE_BRICK.registerItemModel();
        BAT_WING.registerItemModel();
        ENDER_PEARL_PIECE.registerItemModel();
        LLAMA_FUR.registerItemModel();
        POLAR_BEAR_LEATHER.registerItemModel();
        SILVERFISH_SCALE.registerItemModel();
        WITHER_BONE.registerItemModel();

        CHAIN.registerItemModel();
        WITHER_BONE_MEAL.registerItemModel();
    }



    /* old code
    public static void init() {
        /*registerItem(new ItemFood(1, false) {
            @Override
            protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
                super.onFoodEaten(stack, worldIn, player);
                player.addExperienceLevel(8);

            }
        }.setPotionEffect(new PotionEffect(MobEffects.LUCK,)), "emerald_apple");
        * #BUGGED #NEEDSFIX
        *//*
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "rust_dust");

        registerItem(new ItemChisel(), "chisel");

        // Armor
        new FurCostumeArmor();
        new PortableFurnace();
        new PolarBearHood();

        // Weapon
        registerItem(new Hammer(), "hammer");

        // Shield
        registerItem(new CustomShield(400), "iron_shield");
        registerItem(new CustomShield(500), "golden_shield");
        registerItem(new CustomShield(700), "diamond_shield");
    }
    */
}
