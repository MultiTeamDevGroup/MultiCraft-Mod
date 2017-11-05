package io.github.lukas2005.multicraft;

import io.github.lukas2005.multicraft.items.ModItems;
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

        // Crafting (Shaped)
        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_helmet")),
                "FFF",
                        "F F",
                        "   ", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_chestplate")),
                "F F",
                        "FFF",
                        "FFF", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_leggings")),
                 "FFF",
                         "F F",
                         "F F", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(ModItems.getItem("fur_costume_boots")),
                 "F F",
                         "F F",
                         "   ", 'F', ModItems.getItem("llama_fur"));

        addShapedRecipe(new ItemStack(Items.ENDER_PEARL),
                "PPP",
                        "PPP",
                        "PPP", 'P', ModItems.getItem("ender_pearl_piece"));

        addShapedRecipe(new ItemStack(ModItems.getItem("hammer")),
                " I ",
                        " SI",
                        "S  ", 'S', Items.STICK, 'I', Items.IRON_INGOT);

        // Crafting (Shapeless)
        // TODO: Fix this recipe
        addShapelessRecipe(new ItemStack(Items.POTIONITEM, 1, 8260), ModItems.getItem("bat_wing"), Items.POTIONITEM);

        NBTTagCompound levitationPotionNbt = new NBTTagCompound();

        NBTTagCompound displayNBT = new NBTTagCompound();
        displayNBT.setString("Name", "Splash Potion of Levitation");

        levitationPotionNbt.setTag("display", displayNBT);
        Utils.addPotionEffectToNBT(levitationPotionNbt, 25, 1, 600);

        ItemStack potionItemStack = new ItemStack(Items.SPLASH_POTION);
        potionItemStack.setTagCompound(levitationPotionNbt);

        addShapelessRecipe(potionItemStack, ModItems.getItem("bat_wing"), Items.DRAGON_BREATH);


        // Brewing

    }

    public static void addShapedRecipe(ItemStack output, Object...shape) {
        GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath()+"_recipe"), null, output, shape);
    }

    public static void addShapelessRecipe(ItemStack output, Item...items) {
        Ingredient[] ingredients = new Ingredient[items.length];
        for (int i = 0; i < ingredients.length; i++) ingredients[i] = Ingredient.fromItem(items[i]);
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
