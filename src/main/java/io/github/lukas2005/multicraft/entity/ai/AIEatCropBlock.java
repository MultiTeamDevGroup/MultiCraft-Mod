package io.github.lukas2005.multicraft.entity.ai;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.Utils;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;

public class AIEatCropBlock extends EntityAIBase {

    private final EntityRabbit e;
    private final ArrayList<Block> crops;
    private final World world;

    public AIEatCropBlock(EntityRabbit e, Collection<Block> crops) {
        this.e = e;
        world = e.world;
        this.crops = new ArrayList<>(crops);
    }

    @Override
    public boolean shouldExecute() {
        BlockPos posCenter = e.getPosition();

        return Utils.checkForBlocksInArea(posCenter, 1, crops, world, false);
    }

    @Override
    public void startExecuting() {
        BlockPos posCenter = e.getPosition();

        int index = Main.random.nextInt(crops.size());
        index = index-1;
        index = index<0?0:index;

        world.setBlockToAir(Utils.getBlockPosInArea(posCenter, 1, crops.get(index), world, false));
    }
}
