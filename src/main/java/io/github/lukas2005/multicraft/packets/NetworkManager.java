package io.github.lukas2005.multicraft.packets;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.gui.GuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkManager {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    static int i = -1;

    public static void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.INSTANCE, new GuiHandler());
    }

}
