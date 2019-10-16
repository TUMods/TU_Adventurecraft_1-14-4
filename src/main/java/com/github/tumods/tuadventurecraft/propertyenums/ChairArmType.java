package com.github.tumods.tuadventurecraft.propertyenums;

import net.minecraft.util.IStringSerializable;

public enum ChairArmType implements IStringSerializable {
    BOTH("both"),
    LEFT("left"),
    RIGHT("right"),
    NONE("none");

    private final String name;

    private ChairArmType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}
