package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ModItems {

    public static HashMap<String, Item> ModItems = new HashMap<>();

    public static void init() {
        // Food
        registerItem(new RawParrotMeatItem(), "raw_parrot_meat");
        registerItem(new CookedParrotMeatItem(), "cooked_parrot_meat");

        // Materials
        registerItem(new Item(), "llama_fur");
        registerItem(new Item(), "bat_wing");

        // Armor
        registerItem(new FurCostumeArmor.FurCostumeHelmet(), "fur_costume_helmet");
        registerItem(new FurCostumeArmor.FurCostumeChestplate(), "fur_costume_chestplate");
        registerItem(new FurCostumeArmor.FurCostumeLeggings(), "fur_costume_leggings");
        registerItem(new FurCostumeArmor.FurCostumeBoots(), "fur_costume_boots");
    }

    private static void registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        item.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModItems.put(item.getUnlocalizedName(), item);
    }

    public static Item getItem(String itemName) {
        return  ModItems.get("item."+Reference.MOD_ID+"."+itemName);
    }
}
