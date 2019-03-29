package io.github.lukas2005.multicraft.crafting;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import javax.annotation.Nonnull;
import java.io.Console;
import java.util.List;

public class ShapelessCrafting extends ShapelessOreRecipe {

    /**
     * Is the ItemStack that you get when craft the recipe.
     */
    private final ItemStack recipeOutput;

    /**
     * Is a List of ItemStack that composes the recipe.
     */
    public final NonNullList<Ingredient> recipeItems;
    private final String group;
    private final boolean isSimple;

    int nbtCopyTargetSlot = -1;
    int toolDamageSlot = -1;
    private ItemStack itemstack;
    private BlockPos pos;

    /**============================================================================================================*/

    public NonNullList<ItemStack> defaultRecipeGetRemainingItems(InventoryCrafting inv)
    {
        NonNullList<ItemStack> ret = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        for (int i = 0; i < ret.size(); i++)
        {
            ret.set(i, getContainerItem(inv.getStackInSlot(i)));
        }
        return ret;
    }

    private static ThreadLocal<EntityPlayer> craftingPlayer = new ThreadLocal<EntityPlayer>();
    public static void setCraftingPlayer(EntityPlayer player)
    {
        craftingPlayer.set(player);
    }
    public static EntityPlayer getCraftingPlayer()
    {
        return craftingPlayer.get();
    }

    @Nonnull
    public ItemStack getContainerItem(@Nonnull ItemStack stack)
    {
        System.out.println("\n\n\n" + stack.getDisplayName() + ": " + stack);
        if (stack.getItem().isDamageable()) {
//            stack.getItem().setContainerItem(stack.getItem());
            System.out.println("\n\n\n" + stack.getDisplayName() + ":: " + stack);
            System.out.println(stack.getDisplayName() + ": " + stack.getItem().getContainerItem(stack));
            System.out.println(stack.getDisplayName() + ": " + stack.getMetadata());

            if (stack.getItem().hasContainerItem(stack)) {
                System.out.println("\n" + stack.getDisplayName() + ": " + stack);
//                stack = stack.getItem().getContainerItem(stack);
                System.out.println("\n\n\n" + stack.getDisplayName() + ": " + stack);
                stack.copy();
                System.out.println("\n\n\n" + stack.getDisplayName() + ": " + stack);
                if (!stack.isEmpty() && stack.isItemStackDamageable() && stack.getMetadata() > stack.getMaxDamage()) {
                    ForgeEventFactory.onPlayerDestroyItem(craftingPlayer.get(), stack, null);
                    return ItemStack.EMPTY;
                }
                stack.copy();
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    /**============================================================================================================*/

    public ShapelessCrafting(String sgroup, ResourceLocation group, ItemStack output, NonNullList<Ingredient> ingredients, Object... recipe)
    {
        super(group, output, wrapIngredients(recipe));
        this.group = sgroup;
        this.recipeOutput = output;
        this.recipeItems = ingredients;
        boolean simple = true;
        for (Ingredient i : ingredients)
            simple &= i.isSimple();
        this.isSimple = simple;
    }

    public ShapelessCrafting(String sgroup, ResourceLocation group, ItemStack output, NonNullList<Ingredient> ingredients)
    {
        super(group, ingredients, output);

        this.group = sgroup;
        this.recipeOutput = output;
        this.recipeItems = ingredients;
        boolean simple = true;
        for (Ingredient i : ingredients)
            simple &= i.isSimple();
        this.isSimple = simple;
    }

    private static Object[] wrapIngredients(Object... recipe)
    {
        Object[] out = new Object[recipe.length];
        for(int i = 0; i < recipe.length; i++)
            if(recipe[i] instanceof IngredientStack)
                out[i] = new IngredientIngrStack((IngredientStack)recipe[i]);
            else
                out[i] = recipe[i];
        return out;
    }

    /*public ShapelessCrafting(String group, ItemStack output, NonNullList<Ingredient> ingredients) {

        this.group = group;
        this.recipeOutput = output;
        this.recipeItems = ingredients;
        boolean simple = true;
        for (Ingredient i : ingredients)
            simple &= i.isSimple();
        this.isSimple = simple;
    }*/

    @Override
    public ItemStack getCraftingResult(InventoryCrafting matrix)
    {
        if(nbtCopyTargetSlot >= 0&&nbtCopyTargetSlot < getIngredients().size())
            for(int i = 0; i < matrix.getSizeInventory(); i++)
            {
                ItemStack slot = matrix.getStackInSlot(i);
                if(getIngredients().get(nbtCopyTargetSlot).apply(slot))
                {
                    ItemStack out = output.copy();
                    if(!matrix.getStackInSlot(nbtCopyTargetSlot).isEmpty()&&matrix.getStackInSlot(nbtCopyTargetSlot).hasTagCompound())
                        out.setTagCompound(matrix.getStackInSlot(nbtCopyTargetSlot).getTagCompound().copy());
                    return out;
                }
            }
        return super.getCraftingResult(matrix);
    }


    public ShapelessCrafting setNBTCopyTargetRecipe(int slot) {
        this.nbtCopyTargetSlot = slot;
        return this;
    }


    public ShapelessCrafting setToolDamageRecipe(int slot) {
        this.toolDamageSlot = slot;
        return this;
    }

    /*public ShapelessCrafting resultB() {
        this.;
        return this;
    }*/

    /**
     * Recipes with equal group are combined into one button in the recipe book
     */
    @Override
    public String getGroup() {
        return this.group;
    }

    /**
     * Get the result of this recipe, usually for display purposes (e.g. recipe book). If your recipe has more than one
     * possible result (e.g. it's dynamic and depends on its inputs), then return an empty stack.
     */
    @Override
    public ItemStack getRecipeOutput() {
        /*if (itemstack.equals(new ItemStack(Items.PAPER, 3))) {
            Minecraft.getMinecraft().world.spawnEntity(new EntityItem(Minecraft.getMinecraft().world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.LEATHER_SCRAP, 2, 0)));
        }*/
        return this.recipeOutput;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> remains = defaultRecipeGetRemainingItems(inv);
        System.out.println("\n\n\nRemains: " + remains);
        for (int i = 0; i < remains.size(); i++) {
            ItemStack s = inv.getStackInSlot(i);
            ItemStack remain = remains.get(i);
//            System.out.println(remain);
//            System.out.println(s);
            if (toolDamageSlot >= 0 && toolDamageSlot < getIngredients().size()) {
                ItemStack tool = ItemStack.EMPTY;
//                System.out.println(tool);
//                System.out.println(tool.getItem());
                if (tool.getItem().getMaxDamage(tool) > 0) {
                    System.out.println(tool.getDisplayName() + " Damage:" + tool.getItemDamage());
                    System.out.println(tool.getDisplayName() + " MaxDamage:" + tool.getMaxDamage());
                }
                if (remain.isEmpty() && !s.isEmpty() && getIngredients().get(toolDamageSlot).apply(s))
                    tool = s.copy();
                else if (!remain.isEmpty() && getIngredients().get(toolDamageSlot).apply(remain))
                    tool = remain;
                if (!tool.isEmpty() && tool.getMaxDamage() > 0) {
                    tool.setItemDamage(tool.getItemDamage() + 1);
                    System.out.println(tool.getDisplayName() + " Damage:" + tool.getItemDamage());
                    System.out.println(tool.getDisplayName() + " MaxDamage:" + tool.getMaxDamage());
                    if (tool.getItemDamage() > tool.getMaxDamage()) {
                        System.out.println(tool.getDisplayName() + " Damage:" + tool.getItemDamage());
                        System.out.println(tool.getDisplayName() + " MaxDamage:" + tool.getMaxDamage());
                        tool = ItemStack.EMPTY;
                    }
                    remains.set(i, tool);
                }
            }
            if (!s.isEmpty() && remain.isEmpty() && s.getItem() instanceof UniversalBucket) {
                ItemStack empty = ((UniversalBucket) s.getItem()).getEmpty();
                if (!empty.isEmpty())
                    remains.set(i, empty.copy());
            }
        }
        return remains;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        int ingredientCount = 0;
        net.minecraft.client.util.RecipeItemHelper recipeItemHelper = new net.minecraft.client.util.RecipeItemHelper();
        List<ItemStack> inputs = Lists.newArrayList();

        for (int i = 0; i < inv.getHeight(); ++i) {
            for (int j = 0; j < inv.getWidth(); ++j) {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (!itemstack.isEmpty()) {
                    ++ingredientCount;
                    if (this.isSimple)
                        recipeItemHelper.accountStack(itemstack, 1);
                    else
                        inputs.add(itemstack);
                }
            }
        }

        if (ingredientCount != this.recipeItems.size())
            return false;

        if (this.isSimple)
            return recipeItemHelper.canCraft(this, null);

        return net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    /*@Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return this.recipeOutput.copy();
    }*/


    public static ShapelessRecipes deserialize(JsonObject json) {
        String s = JsonUtils.getString(json, "group", "");
        NonNullList<Ingredient> nonnulllist = deserializeIngredients(JsonUtils.getJsonArray(json, "ingredients"));

        if (nonnulllist.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");
        } else if (nonnulllist.size() > 9) {
            throw new JsonParseException("Too many ingredients for shapeless recipe");
        } else {
            ItemStack itemstack = ShapedRecipes.deserializeItem(JsonUtils.getJsonObject(json, "result"), true);
            return new ShapelessRecipes(s, itemstack, nonnulllist);
        }
    }


    private static NonNullList<Ingredient> deserializeIngredients(JsonArray array) {
        NonNullList<Ingredient> nonnulllist = NonNullList.<Ingredient>create();

        for (int i = 0; i < array.size(); ++i) {
            Ingredient ingredient = ShapedRecipes.deserializeIngredient(array.get(i));

            if (ingredient != Ingredient.EMPTY) {
                nonnulllist.add(ingredient);
            }
        }

        return nonnulllist;
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    public boolean canFit(int width, int height) {
        return width * height >= this.recipeItems.size();
    }
}




