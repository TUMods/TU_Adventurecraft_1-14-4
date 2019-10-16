package com.github.tumods.tuadventurecraft.lists;

import com.github.tumods.tuadventurecraft.propertyenums.ChairArmType;
import com.github.tumods.tuadventurecraft.propertyenums.ChairShape;
import net.minecraft.state.EnumProperty;

public class PropertyList {
    public static final EnumProperty<ChairArmType> CHAIR_ARMS = EnumProperty.create("arms", ChairArmType.class);
    public static final EnumProperty<ChairShape> CHAIR_SHAPE = EnumProperty.create("shape", ChairShape.class);
}
