package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;

public class FurCostumeArmor extends ArmorBase {
    public FurCostumeArmor() {
        super(new ResourceLocation(Main.MODID, "fur_costume"),
                6,
                new int[]{2, 4, 3, 2},
                20,
                0,
                SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                true, true, true, true);
    }
}
