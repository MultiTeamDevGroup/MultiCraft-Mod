package io.github.lukas2005.multicraft.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        EnumGuis enumGuis = EnumGuis.values()[ID];
        try {
            return enumGuis.container.getConstructor(enumGuis.containerConstructorParamsTypes).newInstance(enumGuis.containerConstructorParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        EnumGuis enumGuis = EnumGuis.values()[ID];
        try {
            return enumGuis.gui.getConstructor(enumGuis.guiConstructorParamsTypes).newInstance(enumGuis.guiConstructorParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum EnumGuis {

        PORTABLE_FURNACE(PortableFurnaceGui.class, new Class[]{},
                                                   new Object[]{},
                PortableFurnaceContainer.class, new Class[]{},
                                                new Object[]{});

        public final Class<? extends GuiScreen> gui;
        public final Class<?>[] guiConstructorParamsTypes;
        public final Object[] guiConstructorParams;

        public final Class<? extends Container> container;
        public final Class<?>[] containerConstructorParamsTypes;
        public final Object[] containerConstructorParams;

        EnumGuis(Class<? extends GuiScreen> gui,
                 Class<?>[] guiConstructorParamsTypes,
                 Object[] guiConstructorParams,
                 Class<? extends Container> container,
                 Class<?>[] containerConstructorParamsTypes,
                 Object[] containerConstructorParams) {
            this.gui = gui;
            this.guiConstructorParamsTypes = guiConstructorParamsTypes;
            this.guiConstructorParams = guiConstructorParams;
            this.container = container;
            this.containerConstructorParamsTypes = containerConstructorParamsTypes;
            this.containerConstructorParams = containerConstructorParams;
        }

    }

}
