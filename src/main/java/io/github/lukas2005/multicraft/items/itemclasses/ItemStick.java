package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStick extends ItemBase {
    private String[] woods = new String[] {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak"};

    public ItemStick() {
        super("stick", CreativeTabs.MATERIALS);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)) {
            for(int i = 0; i < 6; ++i) {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + woods[stack.getMetadata()];
    }

    @Override
    public void registerItemModel() {
        for(int i = 0; i < 6; i++) {
            Main.proxy.registerItemRenderer(this, i, this.name + "_" + woods[i]);
        }
    }
}
