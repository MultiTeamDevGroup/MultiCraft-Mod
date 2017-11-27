package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.Utils;
import io.github.lukas2005.multicraft.armor.FurCostumeArmor;
import io.github.lukas2005.multicraft.armor.PolarBearHood;
import io.github.lukas2005.multicraft.armor.PortableFurnace;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.HashMap;

public class ModItems {

    public static final HashMap<String, Item> ModItems = new HashMap<>();

    public static void init() {
        // Food
        registerItem(new RawParrotMeatItem(), "raw_parrot_meat");
        registerItem(new CookedParrotMeatItem(), "cooked_parrot_meat");

        // Materials
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "llama_fur");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "bat_wing");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "ender_pearl_piece");
        registerItem(new ChainItem().setCreativeTab(CreativeTabs.MATERIALS), "chain");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "polar_bear_leather");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone");
        registerItem(new Item().setCreativeTab(CreativeTabs.MATERIALS), "silver_fish_scale");
        registerItem(new WitherBoneMeal().setCreativeTab(CreativeTabs.MATERIALS), "wither_bone_meal");

        // Armor
        new FurCostumeArmor(); // It auto-registers itself now :P
        new PortableFurnace();
        new PolarBearHood();

        // Weapon
        registerItem(new Hammer(), "hammer");

        // Shield
        registerItem(new CustomShield(400), "iron_shield");
        registerItem(new CustomShield(500), "golden_shield");
        registerItem(new CustomShield(700), "diamond_shield");
    }

    public static Item registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        item.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModItems.put(item.getUnlocalizedName(), item);
        return item;
    }

    public static Item getItem(String itemName) {
        return ModItems.get("item."+Reference.MOD_ID+"."+itemName);
    }
}
