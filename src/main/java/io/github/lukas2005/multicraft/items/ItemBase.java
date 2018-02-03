package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    protected String name;

    public ItemBase(String name, CreativeTabs tab) {
        this.name = name;
        setUnlocalizedName(Main.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    public void registerItemModel() {
        Main.proxy.registerItemRenderer(this, 0, name);
    }
}
