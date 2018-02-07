package io.github.lukas2005.multicraft.items.itemclasses;

import io.github.lukas2005.multicraft.items.ItemFoodBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEmeraldApple extends ItemFoodBase {
    public ItemEmeraldApple() {
        super(1, 1.2f, false, "emerald_apple");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addExperienceLevel(8);
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 1200));
    }
}
