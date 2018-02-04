package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.entity.tileentity.TileEntityCraftingTable;
import io.github.lukas2005.multicraft.inventory.CustomContainerWorkbench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

import javax.annotation.Nullable;

// #UNUSED
public class CustomCraftingTable extends Block {
    public CustomCraftingTable()
    {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        setRegistryName(Blocks.CRAFTING_TABLE.getRegistryName());
        setUnlocalizedName(Blocks.CRAFTING_TABLE.getUnlocalizedName().substring(5));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityCraftingTable();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            playerIn.displayGui(new CustomCraftingTable.InterfaceCraftingTable(worldIn, pos));
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        }
        return true;
    }

    static class InterfaceCraftingTable implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return "crafting_table";
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(Blocks.CRAFTING_TABLE.getUnlocalizedName() + ".name");
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new CustomContainerWorkbench(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
}