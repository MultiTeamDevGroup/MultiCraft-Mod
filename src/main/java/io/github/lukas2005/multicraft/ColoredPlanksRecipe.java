package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ColoredPlanksRecipe extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        if (inv.getStackInSlot(0).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(1).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(2).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(3).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(4).getItem() == Items.DYE ||
                inv.getStackInSlot(5).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(6).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(7).getItem() == Item.getItemFromBlock(Blocks.PLANKS) ||
                inv.getStackInSlot(8).getItem() == Item.getItemFromBlock(Blocks.PLANKS)) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return new ItemStack(ModBlocks.getBlock("colored_planks"), 8, inv.getStackInSlot(4).getMetadata());
    }

    @Override
    public boolean canFit(int width, int height) {
        return (width == 3 && height == 3) ? true : false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModBlocks.getBlock("colored_planks"), 8);
    }

}
