package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;

public class PolarBearHood extends ArmorBase {
    public PolarBearHood() {
        super(new ResourceLocation(Reference.MOD_ID,
                "polar_bear_hood"),
                5,
                new int[]{1, 2, 3, 1},
                15,
                0.0F,
                SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                true);
    }
}
