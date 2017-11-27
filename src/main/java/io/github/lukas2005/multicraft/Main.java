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

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    @SidedProxy(serverSide = Reference.SERVER_PROXY, clientSide = Reference.CLIENT_PROXY)
    public static IProxy proxy;

    public static final Random random = new Random();

    public static ArrayList<Entity[]> attachedMinecarts = new ArrayList<>();

    @Mod.Instance(Reference.MOD_ID)
    public static Main INSTANCE;

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
