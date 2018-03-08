package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.util.NonNullList;

public class ItemColoredBook extends ItemWritableBook {
    private String name = "book_colored";

    public ItemColoredBook() {
        setUnlocalizedName(Main.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)) {
            for(int i = 0; i < 16; ++i) {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(stack.getMetadata()).getName();
    }

    public void registerItemModel() {
        for(int i = 0; i < 16; i++) {
            Main.proxy.registerItemRenderer(this, i, this.name + "_" + EnumDyeColor.byMetadata(i).getName());
        }
    }
}
