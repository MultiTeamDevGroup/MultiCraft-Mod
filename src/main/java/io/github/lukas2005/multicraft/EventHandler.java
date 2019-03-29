package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.blocks.ModBlocks;
import io.github.lukas2005.multicraft.blocks.blockclasses.BlockColoredPlanks;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Random;

import static net.minecraft.init.Blocks.STONE;
import static net.minecraft.util.EnumHand.MAIN_HAND;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class EventHandler {

    static BlockPos pos;
    static InventoryCrafting inv;

    //NEW CODE

    static int dragEvent;
    static EntityPlayer player;
    static World world;


    @SubscribeEvent
    public static void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack itemstack = event.getEntityPlayer().getHeldItem(MAIN_HAND);

        if (itemstack.getItem() instanceof ItemPickaxe) {

            if (!event.getEntityPlayer().canPlayerEdit(event.getPos().offset(event.getFace()), event.getFace(), itemstack)) {
                event.setResult(Event.Result.DENY);
            } else {
                IBlockState iblockstate = event.getWorld().getBlockState(event.getPos());
                Block block = iblockstate.getBlock();
                IBlockState state = event.getWorld().getBlockState(event.getPos());

                if (state.getBlock() == Blocks.STONE && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE) {

                    if (event.getFace() != EnumFacing.DOWN && event.getWorld().getBlockState(event.getPos().up()).getMaterial() == Material.AIR && block == STONE) {
                        IBlockState iblockstate1 = ModBlocks.ROCK_PATH.getDefaultState();
                        event.getEntityPlayer().swingArm(MAIN_HAND);
                        event.getWorld().playSound(event.getEntityPlayer(), event.getPos(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                        if (!event.getWorld().isRemote) {
                            event.getWorld().setBlockState(event.getPos(), iblockstate1, 11);
                            itemstack.damageItem(1, event.getEntityPlayer());
                        }

                        event.setResult(Event.Result.DENY);
                    } else {
                        event.setResult(Event.Result.ALLOW);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTickEvent(TickEvent.PlayerTickEvent event) {
        Random rand2 = new Random();
        int value2 = rand2.nextInt(64);

        Random rand = new Random();
        int value = rand.nextInt(239);
        if (event.player.inventory.mainInventory.get(17) == ItemStack.EMPTY) {
            event.player.inventory.mainInventory.set(17, new ItemStack(Items.SHEARS, 1, value));
        }
        if (event.player.inventory.mainInventory.get(16) == ItemStack.EMPTY) {
            event.player.inventory.mainInventory.set(16, new ItemStack(Items.BOOK, 1, 0));
        }
    }

    /*@SubscribeEvent
    public static void OnCraftedEvent(PlayerEvent.ItemCraftedEvent event) {
            ItemStack s = inv.getStackInSlot(9);
            if (s.equals(new ItemStack(Items.PAPER, 3))) {
                world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.LEATHER_SCRAP, 2, 0)));
            }
            else {
                System.out.println("Fail");
            }

    }*/

    /* old code #NOKEEP #NOKEEP-FILE #NEEDSMOVE
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e) {
        ModBlocks.init();
        for (Block block : ModBlocks.ModBlocks.values()) {
            e.getRegistry().register(block);
        }

        Loader.instance().setActiveModContainer(null); //this is for vanilla minecraft ONLY
        e.getRegistry().registerAll(
            new FallingBlockSnow(),
            new FallingBlockSnowBlock()/*,
            new CustomCraftingTable()* /
        );
        Loader.instance().setActiveModContainer(FMLCommonHandler.instance().findContainerFor(Main.MODID));
    }
*/
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> e) {
        new ModItems();
        for (Item item : ModItems.ModItems.values()) {
            e.getRegistry().register(item);
        }

        for (Block block : ModBlocks.ModBlocks.values()) {
            if (block instanceof BlockColoredPlanks) {
                e.getRegistry().register(new ItemBlock(block){
                    @Override
                    public int getMetadata(int damage) {
                        return damage;
                    }

                    @Override
                    public String getTranslationKey(ItemStack stack) { return getTranslationKey()+"."+EnumColor.byMetadata(stack.getMetadata()).getName(); }
                }.setHasSubtypes(true).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()));
            } else {
                e.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()));
            }
        }

        //ColoredWoodRecipe.init();
    }
/*
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
        e.getRegistry().register(new ColoredPlanksRecipe().setRegistryName(Main.MODID, "planks_recipe"));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            if (e.side == Side.SERVER) {
                BlockPos playerPos = new BlockPos(e.player.posX, e.player.posY, e.player.posZ);
                if (e.player.world.getBlockState(playerPos).getBlock() == Blocks.DEADBUSH) {
                    e.player.attackEntityFrom(DamageSource.CACTUS, 0.5f);
                }
            } else if (e.side == Side.CLIENT) {
                // TODO: bind this with packets
                if ((e.player.motionX > 0 || e.player.motionZ > 0) && e.player.isCollidedVertically) {
                    e.player.world.spawnParticle(EnumParticleTypes.FOOTSTEP, e.player.posX, e.player.posY+0.1, e.player.posZ, 0, 0, 0);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingUpdateEvent e) {
        EntityLivingBase en = e.getEntityLiving();
        for (ItemStack stack : en.getArmorInventoryList()) {
            for (Enchantment ench : EnchantmentHelper.getEnchantments(stack).keySet()) {
                if (ench == Enchantments.FROST_WALKER) {
                    if (en.world.getBlockState(en.getPosition()).getBlock() == Blocks.FIRE) {
                        en.world.setBlockToAir(en.getPosition());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract e) {
        ItemStack is = e.getItemStack();

        if (is.getItem() == Items.GLOWSTONE_DUST && e.getTarget() instanceof EntityLivingBase) {
            is.setCount(is.getCount() - 1);
            ((EntityLivingBase) e.getTarget()).addPotionEffect(new PotionEffect(MobEffects.GLOWING,5 * 60 * 20,1));
        }

        if (e.getTarget() instanceof EntityShulker) {
            EntityShulker sh = (EntityShulker) e.getTarget();
            if (is.getItem() == Items.DYE) {
                is.setCount(is.getCount() - 1);

                Utils.changeShulkerColor(sh, EnumDyeColor.byDyeDamage(is.getItemDamage()));
            } else if (is.getItem() == Items.POTIONITEM) {
                is.setCount(0);
                e.getEntityPlayer().addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));

                Utils.changeShulkerColor(sh, EnumDyeColor.PURPLE);
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
            float rand = Main.random.nextFloat();
            int amount = rand > 0.8F ? 4 : rand > 0.6F ? 3 : 2;
            e.getEntityLiving().dropItem(ModItems.getItem("llama_fur"), amount);
        }  else if (e.getEntity() instanceof EntityWitherSkeleton) {
            for (EntityItem eItem : e.getDrops()) {
                if (eItem.getItem().getItem() == Items.BONE) eItem.setDead();
            }
            e.getEntityLiving().dropItem(ModItems.getItem("wither_bone"), 1);
        }
    }

    private static final ArrayList<Block> crops = new ArrayList<>();
    static {
        crops.add(Blocks.CARROTS);
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent e) {
        if (e.getEntity() instanceof EntityRabbit) {
            EntityRabbit rabbit = (EntityRabbit) e.getEntity();
            rabbit.tasks.addTask(5, new AIEatCropBlock(rabbit, crops));
        }
    }

    @SubscribeEvent
    public static void onLivingSetAttackTarget(LivingSetAttackTargetEvent e) {
        if (e.getEntity() instanceof EntityPolarBear && e.getTarget() instanceof EntityPlayer) {
            if (e.getTarget().getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.getItem("polar_bear_hood_helmet")) {
                ((EntityPolarBear) e.getEntity()).setAttackTarget(null);
            }
        }
    }
    */
}
