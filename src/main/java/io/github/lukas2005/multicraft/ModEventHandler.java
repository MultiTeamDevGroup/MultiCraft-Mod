package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import io.github.lukas2005.multicraft.utils.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEventHandler {
    private static Random random = new Random();

    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent e) {
        if ((e.getState().getBlock() == Blocks.LEAVES || e.getState().getBlock() == Blocks.LEAVES2) && random.nextInt(40) == 1) {
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
            } else {
                // TODO: bind this with packets
                if ((e.player.motionX > 0 || e.player.motionZ > 0) && e.player.isCollidedVertically) {
                    e.player.world.spawnParticle(EnumParticleTypes.FOOTSTEP, e.player.posX, e.player.posY+0.1, e.player.posZ, 0, 0, 0);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onDrop(LivingDropsEvent e) {
        if (e.getEntity() instanceof EntityParrot) {
            e.getEntityLiving().dropItem(ModItems.RAW_PARROT_MEAT, 1);
        } else if (e.getEntity() instanceof EntityBat) {
            e.getEntityLiving().dropItem(ModItems.BAT_WING, 1);
        }  else if (e.getEntity() instanceof EntityEndermite) {
            e.getEntityLiving().dropItem(ModItems.ENDER_PEARL_PIECE, 1);
        }  else if (e.getEntity() instanceof EntityPolarBear) {
            int amount = random.nextInt(2) + 1;
            e.getEntityLiving().dropItem(ModItems.POLAR_BEAR_LEATHER, amount);
        }  else if (e.getEntity() instanceof EntityLlama) {
            for (EntityItem eItem : e.getDrops()) {
                if(eItem.getItem().getItem() == Items.LEATHER) eItem.setDead();
            }

            float rand = random.nextFloat();
            int amount = rand > 0.8F ? 4 : rand > 0.6F ? 3 : 2;
            e.getEntityLiving().dropItem(ModItems.LLAMA_FUR, amount);
        }  else if (e.getEntity() instanceof EntityWitherSkeleton) {
            for (EntityItem eItem : e.getDrops()) {
                if(eItem.getItem().getItem() == Items.BONE) eItem.setDead();
            }
            e.getEntityLiving().dropItem(ModItems.WITHER_BONE, 1);
        }
    }

    @SubscribeEvent
    public static void onLivingSetAttackTarget(LivingSetAttackTargetEvent e) {
        if (e.getEntity() instanceof EntityPolarBear && e.getTarget() instanceof EntityPlayer) {
            if (e.getTarget().getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.POLAR_BEAR_HOOD) {
                ((EntityPolarBear) e.getEntity()).setAttackTarget(null);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingUpdateEvent e) {
        EntityLivingBase entity = e.getEntityLiving();
        for (ItemStack stack : entity.getArmorInventoryList()) {
            for (Enchantment enchant : EnchantmentHelper.getEnchantments(stack).keySet()) {
                if (enchant == Enchantments.FROST_WALKER) {
                    if (entity.world.getBlockState(entity.getPosition()).getBlock() == Blocks.FIRE) {
                        entity.world.setBlockToAir(entity.getPosition());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract e) {
        ItemStack is = e.getItemStack();

        if (is.getItem() == Items.GLOWSTONE_DUST && e.getTarget() instanceof EntityLivingBase) {
            is.shrink(1);
            ((EntityLivingBase) e.getTarget()).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 6000, 1));
        } else if(is.getItem() == ModItems.COLOR_TAG && e.getTarget() instanceof EntityLivingBase) {
            is.shrink(1);
            if(!e.getTarget().hasCustomName()) {
                if(is.hasDisplayName()) {
                    e.getTarget().setCustomNameTag(Utils.getFormattingCodeFromMeta(is.getMetadata()) + is.getDisplayName());
                }
            } else {
                String oldName = e.getTarget().getCustomNameTag().substring(2);
                e.getTarget().setCustomNameTag(Utils.getFormattingCodeFromMeta(is.getMetadata()) + oldName);
            }
        }
    }

    /* old code

    public static void registerIRecipes(RegistryEvent.Register<IRecipe> e) {
        e.getRegistry().register(new ColoredPlanksRecipe().setRegistryName(Main.MODID, "planks_recipe"));
    }

    /* old code

    @SubscribeEvent
    public static void registerIRecipes(RegistryEvent.Register<IRecipe> e) {
        e.getRegistry().register(new ColoredPlanksRecipe().setRegistryName(Main.MODID, "planks_recipe"));
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract e) {
        ItemStack is = e.getItemStack();
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
    */
}
