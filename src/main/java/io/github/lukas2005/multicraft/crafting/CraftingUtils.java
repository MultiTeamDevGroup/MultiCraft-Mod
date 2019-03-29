package io.github.lukas2005.multicraft.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author BluSunrize - 03.07.2017
 */

import java.util.List;

public class CraftingUtils {
    public static boolean compareToOreName(ItemStack stack, String oreName)
    {
        if(!isExistingOreName(oreName))
            return false;
        List<ItemStack> s = OreDictionary.getOres(oreName);
        for(ItemStack st : s)
            if(OreDictionary.itemMatches(st, stack, false))
                return true;
        return false;
    }

    public static boolean isExistingOreName(String name)
    {
        if(!OreDictionary.doesOreNameExist(name))
            return false;
        else
            return !OreDictionary.getOres(name).isEmpty();
    }

    public static Ingredient createIngredientFromList(List<ItemStack> list)
    {
        return Ingredient.fromStacks(list.toArray(new ItemStack[list.size()]));
    }

    public static ItemStack copyStackWithAmount(ItemStack stack, int amount)
    {
        if(stack.isEmpty())
            return ItemStack.EMPTY;
        ItemStack s2 = stack.copy();
        s2.setCount(amount);
        return s2;
    }
}
