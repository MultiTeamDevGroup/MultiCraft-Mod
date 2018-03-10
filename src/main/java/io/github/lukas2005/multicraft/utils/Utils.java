package io.github.lukas2005.multicraft.utils;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;

public class Utils {
    public static String getFormattingCodeFromMeta(int meta) throws ArrayIndexOutOfBoundsException {
        String[] formattingCodes = new String[]{"§f", "§6", "§d", "§b", "§e", "§a", "§d", "§8", "§7", "§3", "§5", "§1", "§4", "§2", "§c", "§0"};
        return formattingCodes[meta];
    }

    public static void addPotionEffectToItem(ItemStack item, int id, int amplifier, int duration) {
        NBTTagCompound nbt = item.hasTagCompound() ? item.getTagCompound() : new NBTTagCompound();

        NBTTagList customEffectsList = new NBTTagList();
        NBTTagCompound potionNbt = new NBTTagCompound();

        potionNbt.setInteger("Id", id);
        potionNbt.setInteger("Amplifier", amplifier);
        potionNbt.setInteger("Duration", duration); // 600 = (0:30) 1800 = (1:30)

        customEffectsList.appendTag(potionNbt);
        assert nbt != null;
        nbt.setTag("CustomPotionEffects", customEffectsList);
    }
    
    /* TODO: fix these up
    private static Field getField(Class clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getField(superClass, fieldName);
            } else {
                throw e;
            }
        }
    }

    private static boolean checkForBlocksInArea(BlockPos pos2, BlockPos pos1, ArrayList<Block> blocks, World world) {
        for (BlockPos blockPos : BlockPos.getAllInBox(pos2, pos1))
            if (blocks.contains(world.getBlockState(blockPos).getBlock()))
                return true;
        return false;
    }

    public static boolean checkForBlocksInArea(BlockPos from, int radius, ArrayList<Block> blocks, World world, boolean goUpwards) {
        return checkForBlocksInArea(new BlockPos(from.getX()-radius, from.getY(), from.getZ()-radius),
                new BlockPos(from.getX()+radius, from.getY()+(goUpwards?radius:0), from.getZ()+radius), blocks, world);
    }

    private static BlockPos getBlockPosInArea(BlockPos pos2, BlockPos pos1, Block block, World world) {
        for (BlockPos current : BlockPos.getAllInBox(pos2, pos1)) {
            if (block.equals(world.getBlockState(current).getBlock())) {
                return current;
            }
        }
        return null;
    }

    public static BlockPos getBlockPosInArea(BlockPos from, int radius, Block block, World world, boolean goUpwards) {
        return getBlockPosInArea(new BlockPos(from.getX()-radius, from.getY(), from.getZ()-radius),
                new BlockPos(from.getX()+radius, from.getY()+(goUpwards?radius:0), from.getZ()+radius), block, world);
    }

    @SuppressWarnings("unchecked")
    public static void changeShulkerColor(EntityShulker sh, EnumDyeColor color) {
        try {
            Class<? extends EntityShulker> shulkerClass = sh.getClass();

            Field dataManagerField;
            Field colorField;
            try {
                dataManagerField = Utils.getField(shulkerClass, "dataManager");
            } catch (Exception ex) {
                try {
                    dataManagerField = Utils.getField(shulkerClass, "field_70180_af");
                } catch (Exception ex1) {
                    throw ex;
                }
            }
            try {
                colorField = Utils.getField(shulkerClass, "COLOR");
            } catch (Exception ex) {
                try {
                    colorField = Utils.getField(shulkerClass, "field_190770_bw");
                } catch (Exception ex1) {
                    throw ex;
                }
            }
            dataManagerField.setAccessible(true);
            colorField.setAccessible(true);

            EntityDataManager dataManager = (EntityDataManager) dataManagerField.get(sh);
            DataParameter<Byte> COLOR = (DataParameter<Byte>) colorField.get(sh);

            final BigInteger bi = BigInteger.valueOf(color.getMetadata());
            final byte[] bytes = bi.toByteArray();

            dataManager.set(COLOR, bytes[0]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    */
    public static void sendCommand(MinecraftServer server, ICommandSender sender, String cmd, boolean sendCommandFeedback) {
        GameRules rules = sender.getEntityWorld().getGameRules();
        boolean sendCommandFeedbackOrig = rules.getBoolean("sendCommandFeedback");
        boolean logAdminCommandsOrig = rules.getBoolean("logAdminCommands");

        rules.setOrCreateGameRule("sendCommandFeedback", String.valueOf(sendCommandFeedback));
        rules.setOrCreateGameRule("logAdminCommands", String.valueOf(sendCommandFeedback));

        server.commandManager.executeCommand(sender, cmd);

        rules.setOrCreateGameRule("sendCommandFeedback", String.valueOf(sendCommandFeedbackOrig));
        rules.setOrCreateGameRule("logAdminCommands", String.valueOf(logAdminCommandsOrig));

    }

    public static void sendCommand(MinecraftServer server, ICommandSender sender, String cmd) {
        sendCommand(server, sender, cmd, false);
    }

    public static void sendCommand(MinecraftServer server, ICommandSender sender, String cmd, boolean sendCommandFeedback, BlockPos pos) {
        sendCommand(server, sender, cmd.replace("~ ~ ~",pos.getX()+" "+pos.getY()+" "+pos.getZ()), sendCommandFeedback);
    }
    /*
    public static void sendCommand(MinecraftServer server, ICommandSender sender, String cmd, boolean sendCommandFeedback, boolean useSenderPosition) {
        if (useSenderPosition) {
            sendCommand(server, sender, cmd, sendCommandFeedback, sender.getPosition());
        } else {
            sendCommand(server, sender, cmd, sendCommandFeedback);
        }
    }

    /**
     * Open a GUI for a block
     *
    public static void openGui(EntityPlayer player, World world, BlockPos pos, GuiHandler.EnumGuis guiID) {
        player.openGui(Main.instance, guiID.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     *
    public static void openGui(EntityPlayer player, World world, GuiHandler.EnumGuis guiID) {
        openGui(player, world, guiID.ordinal());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     *
    public static void openGui(EntityPlayer player, World world, int guiID) {
        BlockPos pos = player.getPosition();
        player.openGui(Main.instance, guiID, world, pos.getX(), pos.getY(), pos.getZ());
    }
    */
}