package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.packets.NetworkManager;
import io.github.lukas2005.multicraft.proxy.IProxy;
import net.minecraft.entity.Entity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.Random;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "multic";
    public static final String NAME = "MultiCraft";
    public static final String VERSION = "0.1.1";
    public static final String SERVER_PROXY = "io.github.lukas2005.multicraft.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "io.github.lukas2005.multicraft.proxy.ClientProxy";


    @SidedProxy(serverSide = Main.SERVER_PROXY, clientSide = Main.CLIENT_PROXY)
    public static IProxy proxy;

    public static final Random random = new Random(); // "random" > final lol

    public static ArrayList<Entity[]> attachedMinecarts = new ArrayList<>();

    @Mod.Instance(Main.MODID)
    public static Main instance;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        NetworkManager.init();
        proxy.preInit(e);
    }

    @EventHandler
    public static void init(FMLInitializationEvent e) {

        proxy.init(e);
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e) {

        proxy.postInit(e);
    }

}
