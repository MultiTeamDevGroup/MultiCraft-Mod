package io.github.lukas2005.multicraft.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockAncientStoneStairs extends BlockStairs {

    public BlockAncientStoneStairs(IBlockState modelState) {
        super(modelState);
        this.useNeighborBrightness = true;
    }

}
