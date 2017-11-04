package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

    public static void init() {
        // Smelting
        GameRegistry.addSmelting(ModItems.getItem("raw_parrot_meat"), new ItemStack(ModItems.getItem("cooked_parrot_meat")), 0.35f);

        // Crafting (Shaped)
        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_helmet")),
                "FFF",
                        "F F",
                        "   ", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_chestplate")),
                "F F",
                        "FFF",
                        "FFF", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_leggings")),
                 "FFF",
                         "F F",
                         "F F", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_boots")),
                 "F F",
                         "F F",
                         "   ", 'F', ModItems.getItem("llama_fur"));

    }

    public static void addShapedRecipe(ItemStack output, Object...shape) {
        GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath()+"_recipe"), null, output, shape);
    }

}
