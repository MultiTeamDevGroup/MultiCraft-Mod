package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.items.ModItems;
import io.github.lukas2005.multicraft.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Random;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "multic";
    public static final String NAME = "MultiCraft";
    public static final String VERSION = "0.1.1";
    public static final String SERVER_PROXY = "io.github.lukas2005.multicraft.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "io.github.lukas2005.multicraft.proxy.ClientProxy";


    @SidedProxy(serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;

    public static final Random random = new Random(); // "random" > final, lol
    public static ArrayList<Entity[]> attachedMinecarts = new ArrayList<>();

    @Mod.Instance(MODID)
    public static Main instance;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        //NetworkManager.init();
        //proxy.preInit(e);
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {

        //proxy.init(e);
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {
        //proxy.postInit(e);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModBlocks.registerItems(event.getRegistry());
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }
}
