package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> e) {
        for (Item item : ModItems.ModItems.values()) {
            e.getRegistry().register(item);
            Main.proxy.registerItemRender(item);
        }
    }

    @SubscribeEvent
    public static void onDrop(LivingDropsEvent e) {

    }

}
