package io.github.lukas2005.multicraft;

import com.google.common.collect.BiMap;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Field;

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

    public static Field getField(Class clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getField(superClass, fieldName);
            } else {
                throw e;
            }
        }
    }

}