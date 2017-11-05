package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;

public class ColoredPlank extends Block {

    public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumColor.class);

    public ColoredPlank() {
        super(Material.WOOD);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(COLOR, EnumColor.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(COLOR).
    }
}
