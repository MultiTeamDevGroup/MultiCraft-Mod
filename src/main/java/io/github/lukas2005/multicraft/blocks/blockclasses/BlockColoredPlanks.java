package io.github.lukas2005.multicraft.blocks.blockclasses;

import io.github.lukas2005.multicraft.EnumColor;
import io.github.lukas2005.multicraft.blocks.BlockBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockColoredPlanks extends BlockBase {

    public static final PropertyEnum<EnumColor> COLOR = PropertyEnum.create("color", EnumColor.class);

    public BlockColoredPlanks() {
        super(Material.WOOD, "colored_planks", 1, 2f, CreativeTabs.BUILDING_BLOCKS);
        setResistance(15);
        this.getMetadata(0);
        this.getUnlocalizedName();
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumColor.BLACK));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }


    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(COLOR, EnumColor.byMetadata(meta));
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 20;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumColor)state.getValue(COLOR)).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumColor color : EnumColor.values()) {
            items.add(new ItemStack(this, 1, color.getMetadata()));
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(this, 1, state.getValue(COLOR).getMetadata()));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(stack.getMetadata()).getUnlocalizedName();
    }

}
