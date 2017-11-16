package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ColoredPlanks;
import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModClassLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;

import java.lang.reflect.Field;
import java.math.BigInteger;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e) {
        for (Block block : ModBlocks.ModBlocks.values()) {
            e.getRegistry().register(block);
        }

        for (Block toReplace : ModBlocks.BlockSubstitutions.keySet()) {
            Loader.instance().setActiveModContainer(FMLCommonHandler.instance().findContainerFor(toReplace.getRegistryName().getResourceDomain()));
            System.out.println(ModBlocks.BlockSubstitutions.get(toReplace));
            e.getRegistry().register(ModBlocks.BlockSubstitutions.get(toReplace));
        }
        Loader.instance().setActiveModContainer(FMLCommonHandler.instance().findContainerFor(Reference.MOD_ID));

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

                    @Override
                    public String getUnlocalizedName(ItemStack stack) { return getUnlocalizedName()+"."+EnumColor.byMetadata(stack.getMetadata()).getName(); }
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
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            if (e.side == Side.SERVER) {
                BlockPos playerPos = new BlockPos(e.player.posX, e.player.posY, e.player.posZ);

                if (e.player.world.getBlockState(playerPos).getBlock() == Blocks.DEADBUSH) {
                    e.player.attackEntityFrom(DamageSource.CACTUS, 0.5f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract e) {
        ItemStack is = e.getItemStack();

        if (e.getTarget() instanceof EntityShulker) {
            if (is.getItem() == Items.DYE) {
                is.setCount(is.getCount() - 1);
                EntityShulker sh = (EntityShulker) e.getTarget();

                try {
                    Class<? extends EntityShulker> shulkerClass = sh.getClass();

                    Field dataManagerField;
                    Field colorField;
                    try {
                        dataManagerField = Utils.getField(shulkerClass, "dataManager");
                    } catch (Exception ex) {
                        try {
                            dataManagerField = shulkerClass.getDeclaredField("field_70180_af");
                        } catch (Exception ex1) {
                            throw ex1;
                        }
                    }
                    try {
                        colorField = shulkerClass.getDeclaredField("COLOR");
                    } catch (Exception ex) {
                        try {
                            colorField = shulkerClass.getDeclaredField("field_190770_bw");
                        } catch (Exception ex1) {
                            throw ex1;
                        }
                    }
                    dataManagerField.setAccessible(true);
                    colorField.setAccessible(true);

                    EntityDataManager dataManager = (EntityDataManager) dataManagerField.get(sh);
                    DataParameter<Byte> COLOR = (DataParameter<Byte>) colorField.get(sh);

                    final BigInteger bi = BigInteger.valueOf(EnumDyeColor.byDyeDamage(is.getItemDamage()).getMetadata());
                    final byte[] bytes = bi.toByteArray();

                    dataManager.set(COLOR, bytes[0]);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @SubscribeEvent
    public static void onDrop(LivingDropsEvent e) {
        if (e.getEntity() instanceof EntityParrot) {
            e.getEntityLiving().dropItem(ModItems.getItem("raw_parrot_meat"), 1);
        } else if (e.getEntity() instanceof EntityBat) {
            e.getEntityLiving().dropItem(ModItems.getItem("bat_wing"), 1);
        }  else if (e.getEntity() instanceof EntityEndermite) {
            e.getEntityLiving().dropItem(ModItems.getItem("ender_pearl_piece"), 1);
        }  else if (e.getEntity() instanceof EntityPolarBear) {
            e.getEntityLiving().dropItem(ModItems.getItem("polar_bear_leather"), 1);
        }  else if (e.getEntity() instanceof EntityLlama) {
            for (EntityItem eItem : e.getDrops()) {
                if (eItem.getItem().getItem() == Items.LEATHER) eItem.setDead();
            }
            int amount = 2;
            int randomInt = Main.random.nextInt(100);
            if (randomInt < 60) amount = 2;
            if (randomInt > 60 && randomInt < 80) amount = 3;
            if (randomInt > 80 && randomInt <= 100) amount = 4;
            e.getEntityLiving().dropItem(ModItems.getItem("llama_fur"), amount);
        }
    }

}
