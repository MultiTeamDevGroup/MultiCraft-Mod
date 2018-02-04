package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.items.itemclasses.*;
import io.github.lukas2005.multicraft.items.itemclasses.simple.*;
import io.github.lukas2005.multicraft.items.armor.*;
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

    // ARMOR
    public static final FurCostumeHelmet FUR_COSTUME_HELMET = new FurCostumeHelmet();
    public static final FurCostumeChestplate FUR_COSTUME_CHESTPLATE = new FurCostumeChestplate();
    public static final FurCostumeLeggings FUR_COSTUME_LEGGINGS = new FurCostumeLeggings();
    public static final FurCostumeBoots FUR_COSTUME_BOOTS = new FurCostumeBoots();

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
                DIAMOND_SHIELD,
                FUR_COSTUME_HELMET,
                FUR_COSTUME_CHESTPLATE,
                FUR_COSTUME_LEGGINGS,
                FUR_COSTUME_BOOTS
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

        FUR_COSTUME_HELMET.registerItemModel();
        FUR_COSTUME_CHESTPLATE.registerItemModel();
        FUR_COSTUME_LEGGINGS.registerItemModel();
        FUR_COSTUME_BOOTS.registerItemModel();
    }



    /* old code
    public static void init() {
        registerItem(new ItemChisel(), "chisel");
        new PortableFurnace();
        new PolarBearHood();
        registerItem(new Hammer(), "hammer");
    }
    */
}
