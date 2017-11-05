package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class Hammer extends ItemSword {

    public static ToolMaterial mat = EnumHelper.addToolMaterial(Reference.MOD_ID+":hammer", 1, 270,1,9,10);

    public Hammer() {
        super(mat);
    }
}
