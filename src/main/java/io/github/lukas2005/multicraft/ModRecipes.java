package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModItems.RAW_PARROT_MEAT, new ItemStack(ModItems.COOKED_PARROT_MEAT), 1);
    }
}
