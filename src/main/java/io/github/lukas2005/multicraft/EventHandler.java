package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class EventHandler {
    private static Random random = new Random();

    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent e) {
        if((e.getState().getBlock() == Blocks.LEAVES || e.getState().getBlock() == Blocks.LEAVES2) && random.nextInt(40) == 1) {
            e.getDrops().add(new ItemStack(ModItems.ACORN, 1));
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            if (e.side == Side.SERVER) {
                BlockPos playerPos = new BlockPos(e.player.posX, e.player.posY, e.player.posZ);
                if (e.player.world.getBlockState(playerPos).getBlock() == Blocks.DEADBUSH && random.nextInt(40) == 1 && !e.player.isSneaking()) {
                    e.player.attackEntityFrom(DamageSource.CACTUS, 1f);
                }
            }
        }
    }

    /* old code

    @SubscribeEvent
    public static void registerIRecipes(RegistryEvent.Register<IRecipe> e) {
        e.getRegistry().register(new ColoredPlanksRecipe().setRegistryName(Main.MODID, "planks_recipe"));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            if (e.side == Side.CLIENT) {
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
