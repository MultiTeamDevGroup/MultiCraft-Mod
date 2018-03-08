package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemColorTag extends ItemBase {
    public ItemColorTag() {
        super("color_tag", CreativeTabs.MISC);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
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

    @Override
    public void registerItemModel() {
        for(int i = 0; i < 16; i++) {
            Main.proxy.registerItemRenderer(this, i, this.name + "_" + EnumDyeColor.byMetadata(i).getName());
        }
    }
}
