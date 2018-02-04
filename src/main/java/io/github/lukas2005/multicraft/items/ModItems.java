package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.items.itemclasses.*;
import io.github.lukas2005.multicraft.items.itemclasses.simple.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    // FOODS
    public static final ItemCheese CHEESE = new ItemCheese();
    public static final ItemEmeraldApple EMERALD_APPLE = new ItemEmeraldApple();
    public static final ItemRawParrotMeat RAW_PARROT_MEAT = new ItemRawParrotMeat();
    public static final ItemCookedParrotMeat COOKED_PARROT_MEAT = new ItemCookedParrotMeat();

    // BASIC MATERIALS
    public static final ItemAdobeBrick ADOBE_BRICK = new ItemAdobeBrick();
    public static final ItemBatWing BAT_WING = new ItemBatWing();
    public static final ItemEnderPearlPiece ENDER_PEARL_PIECE = new ItemEnderPearlPiece();
    public static final ItemLlamaFur LLAMA_FUR = new ItemLlamaFur();
    public static final ItemPolarBearLeather POLAR_BEAR_LEATHER = new ItemPolarBearLeather();
    public static final ItemRustDust RUST_DUST = new ItemRustDust();
    public static final ItemSilverfishScale SILVERFISH_SCALE = new ItemSilverfishScale();
    public static final ItemWitherBone WITHER_BONE = new ItemWitherBone();

    // VARIOUS THINGS
    public static final ItemChain CHAIN = new ItemChain();
    public static final ItemWitherBoneMeal WITHER_BONE_MEAL = new ItemWitherBoneMeal();

    // SHIELDS
    public static final ItemIronShield IRON_SHIELD = new ItemIronShield();
    public static final ItemGoldenShield GOLDEN_SHIELD = new ItemGoldenShield();
    public static final ItemDiamondShield DIAMOND_SHIELD = new ItemDiamondShield();

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                CHEESE,
                EMERALD_APPLE,
                RAW_PARROT_MEAT,
                COOKED_PARROT_MEAT,
                ADOBE_BRICK,
                BAT_WING,
                ENDER_PEARL_PIECE,
                LLAMA_FUR,
                POLAR_BEAR_LEATHER,
                RUST_DUST,
                SILVERFISH_SCALE,
                WITHER_BONE,
                CHAIN,
                WITHER_BONE_MEAL,
                IRON_SHIELD,
                GOLDEN_SHIELD,
                DIAMOND_SHIELD
        );
    }

    public static void registerModels() {
        CHEESE.registerItemModel();
        EMERALD_APPLE.registerItemModel();
        RAW_PARROT_MEAT.registerItemModel();
        COOKED_PARROT_MEAT.registerItemModel();

        ADOBE_BRICK.registerItemModel();
        BAT_WING.registerItemModel();
        ENDER_PEARL_PIECE.registerItemModel();
        LLAMA_FUR.registerItemModel();
        POLAR_BEAR_LEATHER.registerItemModel();
        RUST_DUST.registerItemModel();
        SILVERFISH_SCALE.registerItemModel();
        WITHER_BONE.registerItemModel();

        CHAIN.registerItemModel();
        WITHER_BONE_MEAL.registerItemModel();

        IRON_SHIELD.registerItemModel();
        GOLDEN_SHIELD.registerItemModel();
        DIAMOND_SHIELD.registerItemModel();
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
    }
    */
}
