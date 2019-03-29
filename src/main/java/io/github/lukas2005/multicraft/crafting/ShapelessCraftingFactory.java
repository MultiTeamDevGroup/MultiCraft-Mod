package io.github.lukas2005.multicraft.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class ShapelessCraftingFactory implements IRecipeFactory
{
    @Override
    public IRecipe parse(JsonContext context, JsonObject json)
    {
        String sgroup = JsonUtils.getString(json, "group", "");
        String group = JsonUtils.getString(json, "group", "");

        NonNullList<Ingredient> ings = NonNullList.create();
        for(JsonElement ele : JsonUtils.getJsonArray(json, "ingredients"))
            ings.add(CraftingHelper.getIngredient(ele, context));

        if(ings.isEmpty())
            throw new JsonParseException("No ingredients for shapeless recipe");

        if(sgroup.isEmpty()) {
            throw new JsonParseException("\n\n ========================================================\n\n   Warning! \"group\" is null. The class has been skipped.\n\n ========================================================\n\n");
        }

        ItemStack result = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);
        ShapelessCrafting recipe = new ShapelessCrafting(sgroup.isEmpty()?null: new ResourceLocation(sgroup).toString(), new ResourceLocation(group), result, ings);

        if(JsonUtils.hasField(json, "damage_tool"))
            recipe.setToolDamageRecipe(JsonUtils.getInt(json, "damage_tool"));

        if(JsonUtils.hasField(json, "copy_nbt"))
            recipe.setNBTCopyTargetRecipe(JsonUtils.getInt(json, "copy_nbt"));

       /* if(JsonUtils.hasField(json, "resultB"))
            recipe.resultB(JsonUtils.getInt(json, "resultB"));*/

        return recipe;
    }
}