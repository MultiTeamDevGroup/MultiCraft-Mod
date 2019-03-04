package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.blocks.blockclasses.BlockAdobeBrick;

import io.github.lukas2005.multicraft.blocks.blockclasses.BlockColoredPlanks;
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockRockPath;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.item.ItemCloth;

import java.util.HashMap;

public class ModBlocks {

    public static HashMap<String, Block> ModBlocks = new HashMap<>();

    public static final BlockAdobeBrick ADOBE_BRICK = new BlockAdobeBrick();
    public static final BlockColoredPlanks COLORED_PLANKS = new BlockColoredPlanks(); //#BUGGED TODO: fix Colored Planks
    public static final BlockRockPath ROCK_PATH = new BlockRockPath();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                ADOBE_BRICK,
                COLORED_PLANKS,
                ROCK_PATH
        );
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ADOBE_BRICK.createItemBlock(),
                COLORED_PLANKS.createItemBlock(),
                ROCK_PATH.createItemBlock()
        );
    }

    public static void registerModels() {
        ADOBE_BRICK.registerItemModel(Item.getItemFromBlock(ADOBE_BRICK));
        COLORED_PLANKS.registerItemModel(Item.getItemFromBlock(COLORED_PLANKS));
        ROCK_PATH.registerItemModel(Item.getItemFromBlock(ROCK_PATH));
    }

    /* old code

    public static BlockBase blockAncientStone = new BlockBase(Material.ROCK, true);

    public static void init() {
        // Building Blocks
        registerBlock(new BlockColoredPlanks().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "colored_planks");
        registerBlock(new BlockRockPath(Material.ROCK).setResistance(30).setHardness(3).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rock_path");
        registerBlock(blockAncientStone.setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "ancient_stone");
        registerBlock(new BlockBase(Material.ROCK, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "engraved_ancient_stone");
        registerBlock(new BlockBase(Material.ROCK, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "volcanic_stone");

        registerBlock(new BlockAncientStoneStairs(blockAncientStone.getDefaultState()), "ancient_stone_stairs");

        registerBlock(new BlockBase((new MaterialLogic(MapColor.SNOW)), true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "snow_brick");
        registerBlock(new BlockBase(Material.SNOW, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "chiseled_snow_brick");
        registerBlock(new BlockBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 9))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 5))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_block");
        registerBlock(new BlockPaneBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 6))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 3))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_bars");
        registerBlock(new BlockDoorBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 6))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 3))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_door");

        chiselMapping.put(getBlock("ancient_stone").getDefaultState(), getBlock("engraved_ancient_stone").getDefaultState());
    }
    */
}
