package io.github.lukas2005.multicraft;

import net.minecraft.util.IStringSerializable;

public enum EnumColor implements IStringSerializable
{
    BLACK("Black"),
    BLUE("Blue"),
    BROWN("Brown"),
    CYAN("Cyan"),
    GREY("Grey"),
    GREEN("Green"),
    LIGHT_BLUE("Light blue"),
    LIGHT_GREY("Light grey"),
    LIME("Lime"),
    MAGENTA("Magenta"),
    ORANGE("Orange"),
    PINK("Pink"),
    PURPLE("Purple"),
    RED("Red"),
    WHITE("White"),
    YELLOW("Yellow");

    public int getMetadata()
    {
        return ordinal();
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public static EnumColor byMetadata(int meta)
    {
        if (meta < 0 || meta >= values().length)
        {
            meta = 0;
        }

        return values()[meta];
    }

    public String getName()
    {
        return this.name;
    }

    private final String name;

    private EnumColor(String i_name)
    {
        this.name = i_name;
    }
}
