package com.github.tumods.tuadventurecraft.itemtypes;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class KnifeItem extends SwordItem {
    public KnifeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
