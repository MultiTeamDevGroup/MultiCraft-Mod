package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ModItems {

    public static HashMap<ResourceLocation, Item> ModItems = new HashMap<>();

    public static void init() {
        registerItem(new RawParrotMeatItem().setRegistryName(Reference.MOD_ID, "raw_parrot_meat").setUnlocalizedName(Reference.MOD_ID+".raw_parrot_meat"));
        registerItem(new CookedParrotMeatItem().setRegistryName(Reference.MOD_ID, "cooked_parrot_meat").setUnlocalizedName(Reference.MOD_ID+".cooked_parrot_meat"));
        registerItem(new LlamaFurItem().setRegistryName(Reference.MOD_ID, "llama_fur").setUnlocalizedName(Reference.MOD_ID+".llama_fur"));
    }

    private static void registerItem(Item item) {
        System.out.println("registering: "+item.getUnlocalizedName());
        ModItems.put(item.getRegistryName(), item);
    }
}
