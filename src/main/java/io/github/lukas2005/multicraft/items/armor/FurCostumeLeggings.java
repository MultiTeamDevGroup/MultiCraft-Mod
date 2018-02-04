package io.github.lukas2005.multicraft.items.armor;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class FurCostumeLeggings extends ItemArmorBase {
    public FurCostumeLeggings() {
        super(Main.furCostume, EntityEquipmentSlot.LEGS, "fur_costume_leggings", 2);
    }
}
