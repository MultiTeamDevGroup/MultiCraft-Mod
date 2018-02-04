package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.utils.Utils;

public class PortableFurnace/* extends ArmorBase */{
    /* #NEEDSFIX #FIXLATER
    private static final KeyBinding KEY_PORTABLE_FURNACE = new KeyBinding("keybind." + Main.MODID + ".portable_furnance_key", Keyboard.KEY_H, "key.categories.inventory");
    private static final PortableFurnaceModel PORTABLE_FURNACE_MODEL = new PortableFurnaceModel(1.0f);

    public PortableFurnace() {
        super(new ResourceLocation(Main.MODID,"portable_furnace"),
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
            if(KEY_PORTABLE_FURNACE.isPressed()) {
                Utils.openGui(player, world, GuiHandler.EnumGuis.PORTABLE_FURNACE);
            }
        }

        @Override
        @Nullable
        @SideOnly(Side.CLIENT)
        public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
            if (itemStack != null) {
                if (itemStack.getItem() instanceof PortableFurnacePiece) {

                    ModelBiped armorModel = PORTABLE_FURNACE_MODEL;

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
    */
}
