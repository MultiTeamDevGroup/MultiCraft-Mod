package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.blocks.blockclasses.BlockRockPath;
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockRustyIronBars;
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockRustyIronBlock;
<<<<<<< HEAD
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockRustyIronDoor;
=======
>>>>>>> blocks, volume 2
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static final BlockBase ADOBE_BRICK = new BlockBase(Material.ROCK, "block_adobe_brick", 2, 9f, CreativeTabs.BUILDING_BLOCKS);
    public static final BlockBase ANCIENT_STONE = new BlockBase(Material.ROCK, "ancient_stone", 1, 1.5f, CreativeTabs.BUILDING_BLOCKS);
    public static final BlockStairsBase ANCIENT_STONE_STAIRS = new BlockStairsBase(ANCIENT_STONE.getDefaultState(), "ancient_stone_stairs", CreativeTabs.BUILDING_BLOCKS);
    public static final BlockBase CHISELED_SNOW_BRICKS = new BlockBase(Material.CRAFTED_SNOW, "chiseled_snow_brick", 1, 0.2f, CreativeTabs.BUILDING_BLOCKS);
    //public static final BlockColoredPlanks COLORED_PLANKS = new BlockColoredPlanks(); #BUGGED TODO: fix Colored Planks
    public static final BlockBase ENGRAVED_ANCIENT_STONE = new BlockBase(Material.ROCK, "engraved_ancient_stone", 1, 1.6f, CreativeTabs.BUILDING_BLOCKS);
    public static final BlockRockPath ROCK_PATH = new BlockRockPath();
    public static final BlockRustyIronBars RUSTY_IRON_BARS = new BlockRustyIronBars();
    public static final BlockRustyIronBlock RUSTY_IRON_BLOCK = new BlockRustyIronBlock();
    //public static final BlockRustyIronDoor RUSTY_IRON_DOOR = new BlockRustyIronDoor();
    public static final BlockBase SNOW_BRICKS = new BlockBase(Material.CRAFTED_SNOW, "snow_brick", 1, 0.2f, CreativeTabs.BUILDING_BLOCKS);
    public static final BlockBase VOLCANIC_STONE = new BlockBase(Material.ROCK, "volcanic_stone", 1, 2f, CreativeTabs.BUILDING_BLOCKS);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                ADOBE_BRICK,
                ANCIENT_STONE,
                ANCIENT_STONE_STAIRS,
                CHISELED_SNOW_BRICKS,
                //COLORED_PLANKS,
                ENGRAVED_ANCIENT_STONE,
                ROCK_PATH,
                RUSTY_IRON_BARS,
                RUSTY_IRON_BLOCK,
                //RUSTY_IRON_DOOR,
                SNOW_BRICKS,
                VOLCANIC_STONE
        );
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ADOBE_BRICK.createItemBlock(),
                ANCIENT_STONE.createItemBlock(),
                ANCIENT_STONE_STAIRS.createItemBlock(),
                CHISELED_SNOW_BRICKS.createItemBlock(),
                //COLORED_PLANKS.createItemBlock(),
                ENGRAVED_ANCIENT_STONE.createItemBlock(),
                ROCK_PATH.createItemBlock(),
                RUSTY_IRON_BARS.createItemBlock(),
                RUSTY_IRON_BLOCK.createItemBlock(),
                //RUSTY_IRON_DOOR.createItemBlock(),
                SNOW_BRICKS.createItemBlock(),
                VOLCANIC_STONE.createItemBlock()
        );
    }

    public static void registerModels() {
        ADOBE_BRICK.registerItemModel(Item.getItemFromBlock(ADOBE_BRICK));
        ANCIENT_STONE.registerItemModel(Item.getItemFromBlock(ANCIENT_STONE));
        ANCIENT_STONE_STAIRS.registerItemModel(Item.getItemFromBlock(ANCIENT_STONE_STAIRS));
        CHISELED_SNOW_BRICKS.registerItemModel(Item.getItemFromBlock(CHISELED_SNOW_BRICKS));
        //COLORED_PLANKS.registerItemModel(Item.getItemFromBlock(COLORED_PLANKS));
        ENGRAVED_ANCIENT_STONE.registerItemModel(Item.getItemFromBlock(ENGRAVED_ANCIENT_STONE));
        ROCK_PATH.registerItemModel(Item.getItemFromBlock(ROCK_PATH));
        RUSTY_IRON_BARS.registerItemModel(Item.getItemFromBlock(RUSTY_IRON_BARS));
        RUSTY_IRON_BLOCK.registerItemModel(Item.getItemFromBlock(RUSTY_IRON_BLOCK));
        //RUSTY_IRON_DOOR.registerItemModel(Item.getItemFromBlock(RUSTY_IRON_DOOR));
        SNOW_BRICKS.registerItemModel(Item.getItemFromBlock(SNOW_BRICKS));
        VOLCANIC_STONE.registerItemModel(Item.getItemFromBlock(VOLCANIC_STONE));
    }

    /* old code
    public static void init() {
<<<<<<< HEAD
=======
        registerBlock(new BlockBase(Material.ROCK, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "volcanic_stone");

        registerBlock(new BlockBase((new MaterialLogic(MapColor.SNOW)), true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "snow_brick");
        registerBlock(new BlockBase(Material.SNOW, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "chiseled_snow_brick");
        registerBlock(new BlockDoorBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 6))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 3))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_door");

>>>>>>> blocks, volume 2
        chiselMapping.put(getBlock("ancient_stone").getDefaultState(), getBlock("engraved_ancient_stone").getDefaultState());
    }
    */
}
