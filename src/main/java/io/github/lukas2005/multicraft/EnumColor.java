package io.github.lukas2005.multicraft;

import net.minecraft.util.IStringSerializable;

public enum EnumColor implements IStringSerializable
{
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    BROWN("Brown"),
    BLUE("Blue"),
    PURPLE("Purple"),
    CYAN("Cyan"),
    LIGHT_GRAY("Light gray"),
    GRAY("Gray"),
    PINK("Pink"),
    LIME("Lime"),
    YELLOW("Yellow"),
    LIGHT_BLUE("Light blue"),
    MAGENTA("Magenta"),
    ORANGE("Orange"),
    WHITE("White");

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
        return this.name.toLowerCase().replace(' ', '_');
    }

    private final String name;

    EnumColor(String i_name)
    {
        this.name = i_name;
    }
}
