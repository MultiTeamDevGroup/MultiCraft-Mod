package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class FurCostumeArmor extends ArmorBase {
    public FurCostumeArmor() {
        super(new ResourceLocation(Reference.MOD_ID, "fur_costume"),
                6,
                new int[]{2, 4, 3, 2},
                20,
                0,
                SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                false,
                true, true, true, true);
    }
}
