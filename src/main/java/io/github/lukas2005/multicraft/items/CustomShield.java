package io.github.lukas2005.multicraft.items;

import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class CustomShield extends ItemShield {

    public CustomShield(int maxDamage) {
        super();
        setMaxDamage(maxDamage);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.translateToLocal(getUnlocalizedName());
    }
}
