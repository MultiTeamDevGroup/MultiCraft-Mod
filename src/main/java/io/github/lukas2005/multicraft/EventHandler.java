package io.github.lukas2005.multicraft;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class EventHandler {
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

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> e) {
        ModItems.init();
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
