package io.github.lukas2005.multicraft.utils;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;

import java.util.Iterator;

public class NBTTagListIterator implements Iterator<NBTBase>, Iterable<NBTBase> {

    private NBTTagList list;
    private int index = 0;

    public NBTTagListIterator(NBTTagList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !list.hasNoTags() && list.get(index) != null;
    }

    @Override
    public NBTBase next() {
        index++;
        return list.get(index-1);
    }

    @Override
    public Iterator<NBTBase> iterator() {
        return this;
    }
}
