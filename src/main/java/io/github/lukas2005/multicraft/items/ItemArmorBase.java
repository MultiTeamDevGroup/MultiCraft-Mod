package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemArmorBase extends ItemArmor {
    private String name;

    public ItemArmorBase(ArmorMaterial material, EntityEquipmentSlot slot, String name, int layer) {
        super(material, layer, slot);
        setRegistryName(name);
        setTranslationKey(Main.MODID + "." + name);
        this.name = name;
        setCreativeTab(Main.tab);
    }

    public void registerItemModel() {
        Main.proxy.registerItemRenderer(this, 0, name);
    }

}
