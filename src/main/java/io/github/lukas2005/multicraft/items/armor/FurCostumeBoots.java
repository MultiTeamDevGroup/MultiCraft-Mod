package io.github.lukas2005.multicraft.items.armor;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class FurCostumeBoots extends ItemArmorBase {
    public FurCostumeBoots() {
        super(Main.furCostume, EntityEquipmentSlot.FEET, "fur_costume_boots", 1);
    }
}
