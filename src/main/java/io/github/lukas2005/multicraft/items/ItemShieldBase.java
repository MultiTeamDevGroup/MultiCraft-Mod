package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class ItemShieldBase extends ItemShield {
    protected String name;

    public ItemShieldBase(int maxDamage, String name) {
        super();
        setMaxDamage(maxDamage);

        this.name = name;
        setTranslationKey(Main.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(Main.tab);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return new TextComponentTranslation(getTranslationKey() + ".name").getFormattedText();
    }

    public void registerItemModel() {
        Main.proxy.registerItemRenderer(this, 0, name);
    }
}
