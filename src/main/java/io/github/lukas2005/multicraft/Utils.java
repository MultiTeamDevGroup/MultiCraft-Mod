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

    public static void addPotionEffectToItem(ItemStack item, int id, int amplifier, int duration) {
        NBTTagCompound nbt = item.hasTagCompound() ? item.getTagCompound() : new NBTTagCompound();
        NBTTagList customEffectsList = new NBTTagList();
        NBTTagCompound potionNbt = new NBTTagCompound();
        potionNbt.setInteger("Id", id);
        potionNbt.setInteger("Amplifier", amplifier);
        potionNbt.setInteger("Duration", duration); // 600 = (0:30) 1800 = (1:30)
        customEffectsList.appendTag(potionNbt);
        nbt.setTag("CustomPotionEffects", customEffectsList);
    }

}