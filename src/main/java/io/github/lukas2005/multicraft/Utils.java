package io.github.lukas2005.multicraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

import java.util.ArrayList;
import java.util.Collection;

public class Utils {

    // 600 = (0:30) 1800 = (1:30)
    public static void addPotionEffectToItem(ItemStack item, Potion potion, int amplifier, int duration) {
        ArrayList<PotionEffect> effects = new ArrayList<>();
        effects.add(new PotionEffect(potion, amplifier, duration));
        PotionUtils.appendEffects(item, effects);
    }

}