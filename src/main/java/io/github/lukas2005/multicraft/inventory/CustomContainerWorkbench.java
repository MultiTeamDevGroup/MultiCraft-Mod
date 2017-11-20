package io.github.lukas2005.multicraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CustomContainerWorkbench extends ContainerWorkbench {

    public CustomContainerWorkbench(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
        super(playerInventory, worldIn, posIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {}
}
