package io.github.lukas2005.multicraft.packets;

import io.github.lukas2005.multicraft.Reference;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkManager {

    public static final SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(Reference.MOD_ID+":network");

    static int i = -1;

    public static void init() {
    }

}
