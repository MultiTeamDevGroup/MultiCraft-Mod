package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ChainItem extends Item {
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityMinecart) {
            NBTTagCompound tag = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
            if (tag.getUniqueId("FirstMinecart") == null) {
                tag.setBoolean("MinecartGotSet", true);
                tag.setLong("gotSetTime", System.currentTimeMillis());
                tag.setUniqueId("FirstMinecart", entity.getUniqueID());
            } else {
                tag.setUniqueId("SecondMinecart", entity.getUniqueID());
            }
            stack.setTagCompound(tag);
            return true;
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        NBTTagCompound tag = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
        if (tag.getBoolean("MinecartGotSet")/* && !tag.getBoolean("Paired")*/) {
            if (tag.getLong("gotSetTime")-System.currentTimeMillis()<=60000) {
                tag.setBoolean("MinecartGotSet", false);
                tag.setLong("gotSetTime", 0);
                tag.setUniqueId("FirstMinecart", null);
                tag.setUniqueId("SecondMinecart", null);
                if (entityIn instanceof EntityPlayer) {
                    EntityPlayer p = (EntityPlayer) entityIn;
                    p.sendMessage(new TextComponentTranslation("message."+ Main.MODID+".chain.pair_failed"));
                }
            } else if (tag.getUniqueId("FirstMinecart")!=null && tag.getUniqueId("SecondMinecart")!=null) {
                if (entityIn instanceof EntityPlayer) {
                    EntityPlayer p = (EntityPlayer) entityIn;
                    p.sendMessage(new TextComponentTranslation("message." + Main.MODID + ".chain.pair_success"));
                }
            }
        }
    }
}
