package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.items.ModItems;
import io.github.lukas2005.multicraft.utils.Utils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ColoredWoodRecipe {

    public static void init() {


        // crafting (Shaped)

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 15),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 0));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 14),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 1));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 13),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 2));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 12),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 3));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 11),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 4));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 10),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 5));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 9),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 6));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 8),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 7));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 7),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 8));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 6),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 9));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 5),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 10));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 4),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 11));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 3),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 12));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 2),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 13));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 1),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 14));

        addShapedRecipe(new ItemStack(ModBlocks.COLORED_PLANKS, 8, 0),
                "PPP",
                "PDP",
                "PPP", 'P', Blocks.PLANKS, 'D', new ItemStack(Items.DYE, 1, 15));


    }

    public static void addShapedRecipe(ItemStack output, Object... shape) {
        GameRegistry.addShapedRecipe(new ResourceLocation(Main.MODID, output.getItem().getRegistryName().getPath() + "_recipe"), null, output, shape);
    }

    public static void addShapelessRecipe(ItemStack output, Item... items) {
        Ingredient[] ingredients = new Ingredient[items.length];
        for (int i = 0; i < ingredients.length; i++) ingredients[i] = Ingredient.fromItem(items[i]);
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID, output.getItem().getRegistryName().getPath() + "_recipe"), null, output, ingredients);
    }

    public static void addShapelessRecipe(ItemStack output, ItemStack... items) {
        Ingredient[] ingredients = new Ingredient[items.length];
        for (int i = 0; i < ingredients.length; i++) ingredients[i] = Ingredient.fromStacks(items[i]);
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID, output.getItem().getRegistryName().getPath() + "_recipe"), null, output, ingredients);
    }

}