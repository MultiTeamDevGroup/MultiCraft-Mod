package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

    public static void init() {
        GameRegistry.addSmelting(ModItems.getItem("raw_parrot_meat"), new ItemStack(ModItems.getItem("cooked_parrot_meat"), 1), 0.35f);
    }

}
