package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.itemclasses.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    // FOODS
    public static final ItemFoodBase CHEESE = new ItemFoodBase(4, 2.3f, true, "cheese");
    public static final ItemEmeraldApple EMERALD_APPLE = new ItemEmeraldApple();
    public static final ItemFoodBase SPLIT_ACORN = new ItemFoodBase(1, 0.4f, false, "split_acorn");
    public static final ItemFoodBase RAW_PARROT_MEAT = new ItemFoodBase(1, 2.1f, true, "raw_parrot_meat");
    public static final ItemFoodBase COOKED_PARROT_MEAT = new ItemFoodBase(4, 4.2f, true, "cooked_parrot_meat");

    // BASIC ITEMS
    public static final ItemAcorn ACORN = new ItemAcorn();
    public static final ItemBase ADOBE_BRICK = new ItemBase("adobe_brick", CreativeTabs.MATERIALS);
    public static final ItemBase BAT_WING = new ItemBase("bat_wing", CreativeTabs.MATERIALS);
    public static final ItemBase ENDER_PEARL_PIECE = new ItemBase("ender_pearl_piece", CreativeTabs.MATERIALS);
    public static final ItemBase LLAMA_FUR = new ItemBase("llama_fur", CreativeTabs.MATERIALS);
    public static final ItemBase POLAR_BEAR_LEATHER = new ItemBase("polar_bear_leather", CreativeTabs.MATERIALS);
    public static final ItemBase RUST_DUST = new ItemBase("rust_dust", CreativeTabs.MATERIALS);
    public static final ItemBase SILVERFISH_SCALE = new ItemBase("silver_fish_scale", CreativeTabs.MATERIALS);
    public static final ItemBase WITHER_BONE = new ItemBase("wither_bone", CreativeTabs.MATERIALS);

    // VARIOUS THINGS
    public static final ItemChain CHAIN = new ItemChain();
    public static final ItemWitherBoneMeal WITHER_BONE_MEAL = new ItemWitherBoneMeal();
    public static final ItemColorTag COLOR_TAG = new ItemColorTag();
    //public static final ItemRustyIronDoor RUSTY_IRON_DOOR = new ItemRustyIronDoor();

    // SHIELDS
    public static final ItemShieldBase IRON_SHIELD = new ItemShieldBase(400, "iron_shield");
    public static final ItemShieldBase GOLDEN_SHIELD = new ItemShieldBase(500, "golden_shield");
    public static final ItemShieldBase DIAMOND_SHIELD = new ItemShieldBase(700, "diamond_shield");
    // ^ #NEEDSTEXTURE TODO: make a diamond shield texture

    // ARMOR
    public static final ItemArmorBase FUR_COSTUME_HELMET = new ItemArmorBase(Main.furCostume, EntityEquipmentSlot.HEAD, "fur_costume_helmet", 1);
    public static final ItemArmorBase FUR_COSTUME_CHESTPLATE = new ItemArmorBase(Main.furCostume, EntityEquipmentSlot.CHEST, "fur_costume_chestplate", 1);
    public static final ItemArmorBase FUR_COSTUME_LEGGINGS = new ItemArmorBase(Main.furCostume, EntityEquipmentSlot.LEGS, "fur_costume_leggings", 2);
    public static final ItemArmorBase FUR_COSTUME_BOOTS = new ItemArmorBase(Main.furCostume, EntityEquipmentSlot.FEET, "fur_costume_boots", 1);
    public static final ItemArmorBase POLAR_BEAR_HOOD = new ItemArmorBase(Main.polarHood, EntityEquipmentSlot.HEAD, "polar_bear_hood", 1);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                CHEESE,
                EMERALD_APPLE,
                SPLIT_ACORN,
                RAW_PARROT_MEAT,
                COOKED_PARROT_MEAT,
                ACORN,
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
                //RUSTY_IRON_DOOR,
                COLOR_TAG,
                IRON_SHIELD,
                GOLDEN_SHIELD,
                //DIAMOND_SHIELD,
                FUR_COSTUME_HELMET,
                FUR_COSTUME_CHESTPLATE,
                FUR_COSTUME_LEGGINGS,
                FUR_COSTUME_BOOTS,
                POLAR_BEAR_HOOD
        );
    }

    public static void registerModels() {
        CHEESE.registerItemModel();
        EMERALD_APPLE.registerItemModel();
        SPLIT_ACORN.registerItemModel();
        RAW_PARROT_MEAT.registerItemModel();
        COOKED_PARROT_MEAT.registerItemModel();

        ACORN.registerItemModel();
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
        COLOR_TAG.registerItemModel();
        //RUSTY_IRON_DOOR.registerItemModel();

        IRON_SHIELD.registerItemModel();
        GOLDEN_SHIELD.registerItemModel();
        //DIAMOND_SHIELD.registerItemModel();

        FUR_COSTUME_HELMET.registerItemModel();
        FUR_COSTUME_CHESTPLATE.registerItemModel();
        FUR_COSTUME_LEGGINGS.registerItemModel();
        FUR_COSTUME_BOOTS.registerItemModel();
        POLAR_BEAR_HOOD.registerItemModel();
    }



    /* old code
    public static void init() {
        registerItem(new ItemChisel(), "chisel");
        new PortableFurnace();
        registerItem(new Hammer(), "hammer");
    }
    */
}
