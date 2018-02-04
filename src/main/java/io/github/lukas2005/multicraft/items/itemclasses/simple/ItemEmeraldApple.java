package io.github.lukas2005.multicraft.items.itemclasses.simple;

import io.github.lukas2005.multicraft.items.ItemFoodBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEmeraldApple extends ItemFoodBase {
    public ItemEmeraldApple() {
        super(1, 1.2f, false, "emerald_apple");
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        player.addExperienceLevel(8);
    }

    /*
    * found a line in the old code
    * ".setPotionEffect(new PotionEffect(MobEffects.LUCK,))"
    * what does this do?
    */
}
