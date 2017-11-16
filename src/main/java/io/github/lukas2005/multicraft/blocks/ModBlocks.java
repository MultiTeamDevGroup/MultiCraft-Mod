package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;

public class ModBlocks {

    public static HashMap<String, Block> ModBlocks = new HashMap<>();
    public static HashMap<Block, Block> BlockSubstitutions = new HashMap<>();

    public static void init() {
        // Building Blocks
        registerBlock(new ColoredPlanks().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "colored_planks");
        registerBlock(new BlockPath(Material.ROCK).setResistance(30).setHardness(3).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rock_path");



        // Tree Blocks
        //registerBlock();

        // Substitutions
        System.out.println(new FallingBlockSnow());

        registerBlockSubstitution(Blocks.SNOW_LAYER, new FallingBlockSnow());
        registerBlockSubstitution(Blocks.SNOW, new FallingBlockSnowBlock());
    }

    private static void registerBlock(Block block, String name) {
        block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        block.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModBlocks.put(block.getUnlocalizedName(), block);
    }

    private static void registerBlockSubstitution(Block toReplace, Block blockReplacement) {
        blockReplacement.setRegistryName(toReplace.getRegistryName());
        blockReplacement.setUnlocalizedName(toReplace.getUnlocalizedName());
        System.out.println(blockReplacement);
        BlockSubstitutions.put(toReplace, blockReplacement);
    }

    public static Block getBlock(String itemName) {
        return ModBlocks.get("tile."+Reference.MOD_ID+"."+itemName);
    }
}
