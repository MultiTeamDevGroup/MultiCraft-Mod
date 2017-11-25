package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class FurCostumeArmor {

    private static final ItemArmor.ArmorMaterial furArmorMaterial = EnumHelper.addArmorMaterial(Reference.MOD_ID+":furArmorMaterial", Reference.MOD_ID+":fur", 6, new int[]{2, 4, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

    public static class FurCostumeHelmet extends ItemArmor {

        public FurCostumeHelmet() {
            super(furArmorMaterial, 0, EntityEquipmentSlot.HEAD);
        }
    }

    public static class FurCostumeChestplate extends ItemArmor {

        public FurCostumeChestplate() {
            super(furArmorMaterial, 0, EntityEquipmentSlot.CHEST);
        }
    }

    public static class FurCostumeLeggings extends ItemArmor {

        public FurCostumeLeggings() {
            super(furArmorMaterial, 1, EntityEquipmentSlot.LEGS);
        }
    }
    public static class FurCostumeBoots extends ItemArmor {

        public FurCostumeBoots() {
            super(furArmorMaterial, 0, EntityEquipmentSlot.FEET);
        }
    }

}
