package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {
    protected String name;
    public ItemFoodBase(int hungerBars, float saturation, boolean isWolfFood, String name) {
        super(hungerBars, saturation, isWolfFood);
        this.name = name;
        setRegistryName(name);
        setUnlocalizedName(Main.MODID + "." + name);
        setCreativeTab(CreativeTabs.FOOD);
    }

    public void registerItemModel() {
        Main.proxy.registerItemRenderer(this, 0, name);
    }
}
