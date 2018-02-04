package io.github.lukas2005.multicraft.items.armor;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class FurCostumeChestplate extends ItemArmorBase {
    public FurCostumeChestplate() {
        super(Main.furCostume, EntityEquipmentSlot.CHEST, "fur_costume_chestplate", 1);
    }
}
