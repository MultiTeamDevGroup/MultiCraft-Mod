package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.items.itemclasses.ItemBatWing;
import io.github.lukas2005.multicraft.items.itemclasses.ItemRawParrotMeat;
import io.github.lukas2005.multicraft.items.itemclasses.ItemCookedParrotMeat;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static final ItemRawParrotMeat RAW_PARROT_MEAT = new ItemRawParrotMeat();
    public static final ItemCookedParrotMeat COOKED_PARROT_MEAT = new ItemCookedParrotMeat();
    public static final ItemBatWing BAT_WING = new ItemBatWing();

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                RAW_PARROT_MEAT,
                COOKED_PARROT_MEAT,
                BAT_WING
        );
    }

    public static void registerModels() {
        RAW_PARROT_MEAT.registerItemModel();
        COOKED_PARROT_MEAT.registerItemModel();
        BAT_WING.registerItemModel();
    }



    /* old code
    public static final HashMap<String, Item> ModItems = new HashMap<>();


    public static void init() {
        // Food
        registerItem(new ItemRawParrotMeat(), "raw_parrot_meat");
        registerItem(new CookedParrotMeatItem(), "cooked_parrot_meat");
        registerItem(new ItemCheese().setCreativeTab(CreativeTabs.FOOD), "cheese");

        // Materials
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "llama_fur");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "ender_pearl_piece");
        registerItem(new ChainItem().setCreativeTab(CreativeTabs.MATERIALS), "chain");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "polar_bear_leather");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "silver_fish_scale");
        registerItem(new WitherBoneMeal().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone_meal");
        registerItem(new ItemAdobeBrick().setCreativeTab(CreativeTabs.MATERIALS), "adobe_brick");
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
        item.setRegistryName(new ResourceLocation(Main.MODID, name));
        item.setUnlocalizedName(Main.MODID+"."+name);
        ModItems.put(item.getUnlocalizedName(), item);
        return item;
    }

    public static Item getItem(String itemName) {
        return ModItems.get("item."+Main.MODID+"."+itemName);
    }
    */
}
