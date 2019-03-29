package io.github.lukas2005.multicraft.world.gen;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static net.minecraftforge.common.BiomeDictionary.Type.SAVANNA;


public class OreGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension()== 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.RUBY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 10, random.nextInt(3) + 1, 1, SAVANNA);
    }

    private void generateOre(IBlockState ore, World world, Random random,int x, int z, int minY, int maxY, int size, int chances, BiomeDictionary.Type... biomes){
        int deltaY = maxY - minY;
        for(int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            for(BiomeDictionary.Type biome : biomes)
                if(BiomeDictionary.hasType(world.getBiome(pos), biome) && biome == SAVANNA)
                    generator.generate(world, random, pos);

        }
    }
}
