package com.github.tumods.tuadventurecraft.propertyenums;

import net.minecraft.util.IStringSerializable;

public enum ChairShape implements IStringSerializable {
    STRAIGHT("straight");

    private final String name;

    private ChairShape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
