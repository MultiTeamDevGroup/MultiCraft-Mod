package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;

public class ArmorBase {

    private ResourceLocation name;
    private ItemArmor.ArmorMaterial material;

    private HashMap<EntityEquipmentSlot, Item> armorPieces = new HashMap<>();

    public ArmorBase(ResourceLocation name, int durability, int[] reductionAmounts, int enchantability, float toughtness, SoundEvent equipSound, boolean...enabledArmorPieces) {
        this.name = name;
        material = EnumHelper.addArmorMaterial(name.toString()+"Material", name.toString(), durability, reductionAmounts, enchantability, equipSound, toughtness);
        for (int i = 0; i<enabledArmorPieces.length; i++) {
            if (enabledArmorPieces[i]) {
                switch (i) {
                    case (0):
                        armorPieces.put(EntityEquipmentSlot.HEAD, ModItems.registerItem(new Helmet(), name.getResourcePath()+"_helmet"));
                        break;
                    case (1):
                        armorPieces.put(EntityEquipmentSlot.CHEST, ModItems.registerItem(new Chestplate(), name.getResourcePath()+"_chestplate"));
                        break;
                    case (2):
                        armorPieces.put(EntityEquipmentSlot.LEGS, ModItems.registerItem(new Leggings(), name.getResourcePath()+"_leggings"));
                        break;
                    case (3):
                        armorPieces.put(EntityEquipmentSlot.FEET, ModItems.registerItem(new Boots(), name.getResourcePath()+"_boots"));
                        break;
                }
            }
        }
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
