package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ColoredPlanks;
import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e) {
        for (Block block : ModBlocks.ModBlocks.values()) {
            e.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> e) {
        for (Item item : ModItems.ModItems.values()) {
            e.getRegistry().register(item);
        }

        for (Block block : ModBlocks.ModBlocks.values()) {
            if (block instanceof ColoredPlanks) {
                e.getRegistry().register(new ItemBlock(block){
                    @Override
                    public int getMetadata(int damage) {
                        return damage;
                    }
                }.setHasSubtypes(true).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
            } else {
                e.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
            }
        }

        ModCrafting.init();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent e) {
        for (Item item : ModItems.ModItems.values()) {
            Main.proxy.registerItemRender(item);
        }

        for (Block block : ModBlocks.ModBlocks.values()) {
            Main.proxy.registerBlockRender(block);
        }
    }

    @SubscribeEvent
    public static void registerIRecipes(RegistryEvent.Register<IRecipe> e) {
        e.getRegistry().register(new ColoredPlanksRecipe().setRegistryName(Reference.MOD_ID, "planks_recipe"));
    }

    @SubscribeEvent
    public static void onDrop(LivingDropsEvent e) {
        System.out.println(e.getEntityLiving().getClass().getName());
        switch (e.getEntityLiving().getClass().getName()) {
            case("net.minecraft.entity.passive.EntityParrot"):
                e.getEntityLiving().dropItem(ModItems.getItem("raw_parrot_meat"), 1);
                break;
            case("net.minecraft.entity.passive.EntityBat"):
                e.getEntityLiving().dropItem(ModItems.getItem("bat_wing"), 1);
                break;
            case("net.minecraft.entity.monster.EntityEndermite"):
                e.getEntityLiving().dropItem(ModItems.getItem("ender_pearl_piece"), 1);
                break;
            case("net.minecraft.entity.passive.EntityLlama"):
                for (EntityItem eItem : e.getDrops()) {
                    if (eItem.getItem().getItem() == Items.LEATHER) eItem.setDead();
                }
                int amount = 2;
                int randomInt = Main.random.nextInt(100);
                if (randomInt < 60) amount = 2;
                if (randomInt > 60 && randomInt < 80) amount = 3;
                if (randomInt > 80 && randomInt <= 100) amount = 4;
                e.getEntityLiving().dropItem(ModItems.getItem("llama_fur"), amount);
                break;
        }
    }

}
