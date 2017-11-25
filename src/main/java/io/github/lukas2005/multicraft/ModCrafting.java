package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

    public static void init() {
        // Smelting
        GameRegistry.addSmelting(ModItems.getItem("raw_parrot_meat"), new ItemStack(ModItems.getItem("cooked_parrot_meat")), 0.35f);

        // Crafting (Shapeless)
        // TODO: Fix this recipe
        addShapelessRecipe(new ItemStack(Items.POTIONITEM, 1, 8260), ModItems.getItem("bat_wing"), Items.POTIONITEM);

        addShapelessRecipe(new ItemStack(ModItems.getItem("wither_bone_meal"), 3), ModItems.getItem("wither_bone"));


        NBTTagCompound nbt = new NBTTagCompound();
        NBTTagCompound displayNBT = new NBTTagCompound();
        displayNBT.setString("LocName", "Splash Potion of Levitation");
        nbt.setTag("display", displayNBT);

        ItemStack potionItemStack = new ItemStack(Items.SPLASH_POTION);
        potionItemStack.setTagCompound(nbt);

        Utils.addPotionEffectToItem(potionItemStack, 25, 1 , 600);

        addShapelessRecipe(potionItemStack, ModItems.getItem("bat_wing"), Items.DRAGON_BREATH);

        nbt = new NBTTagCompound();
        displayNBT = new NBTTagCompound();
        displayNBT.setString("LocName", "Lingering Potion of Levitation");
        nbt.setTag("display", displayNBT);

        ItemStack lingeringPotionItemStack = new ItemStack(Items.LINGERING_POTION);
        lingeringPotionItemStack.setTagCompound(nbt);

        Utils.addPotionEffectToItem(lingeringPotionItemStack, 25, 1 , 600);

        addShapelessRecipe(lingeringPotionItemStack, potionItemStack, new ItemStack(Items.DRAGON_BREATH));

        // Crafting (Shaped)

        addShapedRecipe(new ItemStack(Items.ENDER_PEARL), //ender_pearl
                "PPP",
                        "PPP",
                        "PPP", 'P', ModItems.getItem("ender_pearl_piece"));
        

        addShapedRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), //chainmail_leggings
                "FFF",
                        "F F",
                        "F F", 'F', ModItems.getItem("chain"));

        addShapedRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), //chainmail_boots
                "   ",
                        "F F",
                        "F F", 'F', ModItems.getItem("chain"));

        addShapedRecipe(new ItemStack(ModItems.getItem("chain")), //chain
                "I I",
                        " I ",
                        "I I", 'I', Items.IRON_NUGGET);

        nbt = new NBTTagCompound();
        displayNBT = new NBTTagCompound();
        displayNBT.setString("LocName", "Tipped Arrow of Levitation");
        nbt.setTag("display", displayNBT);

        ItemStack tippedArrowItemStack = new ItemStack(Items.TIPPED_ARROW, 8);
        tippedArrowItemStack.setTagCompound(nbt);

        Utils.addPotionEffectToItem(tippedArrowItemStack, 25, 1 , 600);

        addShapedRecipe(tippedArrowItemStack,
                "AAA",
                        "APA",
                        "AAA", 'A', Items.ARROW, 'P', lingeringPotionItemStack);

        addShapedRecipe(new ItemStack(ModItems.getItem("iron_shield")),
                "WIW",
                        "IGI",
                        "WIW", 'W', Blocks.PLANKS, 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT);

        addShapedRecipe(new ItemStack(ModItems.getItem("golden_shield")),
                "GDG",
                        "GIG",
                        "IGI", 'D', Items.DIAMOND, 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT);

        // Brewing

    }

    private static void addShapedRecipe(ItemStack output, Object... shape) {
        GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath()+"_recipe"), null, output, shape);
    }

    private static void addShapelessRecipe(ItemStack output, Item... items) {
        Ingredient[] ingredients = new Ingredient[items.length];
        for (int i = 0; i < ingredients.length; i++) ingredients[i] = Ingredient.fromItem(items[i]);
        GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath()+"_recipe"), null, output, ingredients);
    }

    private static void addShapelessRecipe(ItemStack output, ItemStack... items) {
        Ingredient[] ingredients = new Ingredient[items.length];
        for (int i = 0; i < ingredients.length; i++) ingredients[i] = Ingredient.fromStacks(items[i]);
        GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath()+"_recipe"), null, output, ingredients);
    }

//    /**
//     *
//     * @param output output potion
//     * @param magic see <a href="https://github.com/Aurilux/Xth-uoth/blob/master/src/main/java/aurilux/xthuoth/common/init/ModPotions.java">this</> for explanation
//     */
//    public static void addBrewingRecipe(Potion output, String magic) {
//        int potionOffset = Potion.REGISTRY.getKeys().size();
//        Potion[] potionTypes = new Potion[potionOffset + 1];
//        System.arraycopy(Potion.REGISTRY, 0, potionTypes, 0, potionOffset);
//        ReflectionUtils.setProtectedValue(Potion.class, null, potionTypes, "potionTypes", "field_76425_a");
//        Potion
//    }

}
