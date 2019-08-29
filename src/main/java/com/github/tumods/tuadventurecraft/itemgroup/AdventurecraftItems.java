package com.github.tumods.tuadventurecraft.itemgroup;

import com.github.tumods.tuadventurecraft.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AdventurecraftItems extends ItemGroup {
    public AdventurecraftItems() {
        super("adventurecraft_items");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemList.ingot_copper);
    }
}
