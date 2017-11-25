package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;

public class ArmorBase {

    protected ResourceLocation name;
    protected ItemArmor.ArmorMaterial material;

    protected HashMap<EntityEquipmentSlot, Item> armorPieces = new HashMap<>();

    public ArmorBase(ResourceLocation name, int durability, int[] reductionAmounts, int enchantability, float toughtness, SoundEvent equipSound, boolean...enabledArmorPieces) {
        this.name = name;
        material = EnumHelper.addArmorMaterial(name.toString()+"_material", name.toString(), durability, reductionAmounts, enchantability, equipSound, toughtness);

        for (int i = 0; i<enabledArmorPieces.length; i++) {
            if (enabledArmorPieces[i]) {
                EntityEquipmentSlot slot = EntityEquipmentSlot.HEAD;
                switch (i) {
                    case (0):
                        slot = EntityEquipmentSlot.HEAD;
                        break;
                    case (1):
                        slot = EntityEquipmentSlot.CHEST;
                        break;
                    case (2):
                        slot = EntityEquipmentSlot.LEGS;
                        break;
                    case (3):
                        slot = EntityEquipmentSlot.FEET;
                        break;
                }
                armorPieces.put(slot, ModItems.registerItem(getItemArmorInstanceFromSlot(slot), name.getResourcePath()+"_"+getNameFromSlot(slot)));
            }
        }
    }

    public static String getNameFromSlot(EntityEquipmentSlot slot) {
        switch (slot) {
            case HEAD:
                return "helmet";
            case CHEST:
                return "chestplate";
            case LEGS:
                return "leggings";
            case FEET:
                return "boots";
        }
        return null;
    }

    public ItemArmor getItemArmorInstanceFromSlot(EntityEquipmentSlot slot) {
        switch (slot) {
            case HEAD:
                return new Helmet();
            case CHEST:
                return new Chestplate();
            case LEGS:
                return new Leggings();
            case FEET:
                return new Boots();
        }
        return null;
    }

    /**
     * Use for custom fancy armor with custom fancy things
     */
    public void replaceArmorPiece(EntityEquipmentSlot slot, ItemArmor newPiece) {
        ModItems.ModItems.remove(armorPieces.get(slot));
        armorPieces.remove(slot);
        armorPieces.put(slot, ModItems.registerItem(newPiece, name.getResourcePath()+"_"+getNameFromSlot(slot)));
    }

    public class Helmet extends ItemArmor {
        public Helmet() {
            super(material, 0, EntityEquipmentSlot.HEAD);
        }
    }
    public class Chestplate extends ItemArmor {
        public Chestplate() {
            super(material, 0, EntityEquipmentSlot.CHEST);
        }
    }
    public class Leggings extends ItemArmor {
        public Leggings() {
            super(material, 1, EntityEquipmentSlot.LEGS);
        }
    }
    public class Boots extends ItemArmor {
        public Boots() {
            super(material, 0, EntityEquipmentSlot.FEET);
        }
    }

}
