package io.github.lukas2005.multicraft.items.armor;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class PolarBearHood extends ItemArmorBase {
    public PolarBearHood() {
        super(Main.polarHood, EntityEquipmentSlot.HEAD, "polar_bear_hood", 1);
    }
}
