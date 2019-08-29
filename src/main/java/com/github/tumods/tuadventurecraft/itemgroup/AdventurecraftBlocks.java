package com.github.tumods.tuadventurecraft.itemgroup;

import com.github.tumods.tuadventurecraft.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AdventurecraftBlocks extends ItemGroup {
    public AdventurecraftBlocks() {
        super("adventurecraft_blocks");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.block_copper));
    }
}
