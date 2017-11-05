package io.github.lukas2005.multicraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Utils {

    public static NBTTagCompound addPotionEffectToNBT(NBTTagCompound nbt, int id, int amplifier, int duration) {
        NBTTagList customEffectsList = new NBTTagList();
        NBTTagCompound potionNbt = new NBTTagCompound();
        potionNbt.setInteger("Id", id);
        potionNbt.setInteger("Amplifier", amplifier);
        potionNbt.setInteger("Duration", duration); // 600 = (0:30) 1800 = (1:30)
        customEffectsList.appendTag(potionNbt);
        nbt.setTag("CustomPotionEffects", customEffectsList);
        return nbt;
    }

}