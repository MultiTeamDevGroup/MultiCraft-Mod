package io.github.lukas2005.multicraft.items.itemclasses.simple;

import io.github.lukas2005.multicraft.items.ItemFoodBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import static net.minecraft.init.MobEffects.LUCK;

public class ItemEmeraldApple extends ItemFoodBase {
    public ItemEmeraldApple() {
        super(5, 1.2f, false, "emerald_apple");
    }

    //@Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addExperienceLevel(8);
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 1200, 0));
    }

    /*
    * found a line in the old code
    * ".setPotionEffect(new PotionEffect(MobEffects.LUCK,))"
    * what does this do?
    *
    * Give the luck effect.
    */
}
