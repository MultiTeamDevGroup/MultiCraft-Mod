package io.github.lukas2005.multicraft.items;

import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

class CustomShield extends ItemShield {

    public CustomShield(int maxDamage) {
        super();
        setMaxDamage(maxDamage);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return new TextComponentTranslation(getUnlocalizedName()+".name").getFormattedText();
    }
}
