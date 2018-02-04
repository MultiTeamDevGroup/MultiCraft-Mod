package io.github.lukas2005.multicraft.items.armor;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class FurCostumeHelmet extends ItemArmorBase {
    public FurCostumeHelmet() {
        super(Main.furCostume, EntityEquipmentSlot.HEAD, "fur_costume_helmet", 1);
    }
}
