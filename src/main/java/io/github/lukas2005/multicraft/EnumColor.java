package io.github.lukas2005.multicraft;

import net.minecraft.util.IStringSerializable;

public enum EnumColor implements IStringSerializable
{
    WHITE("White"),
    ORANGE("Orange"),
    MAGENTA("Magenta"),
    LIGHT_BLUE("Light blue"),
    YELLOW("Yellow"),
    LIME("Lime"),
    PINK("Pink"),
    GRAY("Gray"),
    LIGHT_GRAY("Light gray"),
    CYAN("Cyan"),
    PURPLE("Purple"),
    BLUE("Blue"),
    BROWN("Brown"),
    GREEN("Green"),
    RED("Red"),
    BLACK("Black");


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
