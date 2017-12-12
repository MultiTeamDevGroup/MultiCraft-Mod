package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.utils.Utils;
import io.github.lukas2005.multicraft.gui.GuiHandler;
import io.github.lukas2005.multicraft.proxy.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class PortableFurnace extends ArmorBase {

    public PortableFurnace() {
        super(new ResourceLocation(Reference.MOD_ID,"portable_furnace"),
                6, new int[]{0,1,0,0},
                0,
                0,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                false, true);

        replaceArmorPiece(EntityEquipmentSlot.CHEST, new PortableFurnacePiece());
    }

    private class PortableFurnacePiece extends Chestplate {
        @Override
        public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
            if (ClientProxy.KEY_PORTABLE_FURNANCE.isPressed()) {
                Utils.openGui(player, world, GuiHandler.EnumGuis.PORTABLE_FURNACE);
            }
        }

        @Override
        @Nullable
        @SideOnly(Side.CLIENT)
        public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
            if (itemStack != null) {
                if (itemStack.getItem() instanceof PortableFurnacePiece) {

                    ModelBiped armorModel = ClientProxy.PORTABLE_FURNACE_MODEL;

                    armorModel.bipedBody.showModel = true;

                    armorModel.isSneak = defaultModel.isSneak;
                    armorModel.isRiding = defaultModel.isRiding;
                    armorModel.isChild = defaultModel.isChild;
                    armorModel.rightArmPose = defaultModel.rightArmPose;
                    armorModel.leftArmPose = defaultModel.leftArmPose;

                    return armorModel;
                }
            }
            return null;
        }
    }

}
