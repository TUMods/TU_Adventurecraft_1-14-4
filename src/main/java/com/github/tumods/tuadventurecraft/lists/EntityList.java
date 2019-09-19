package com.github.tumods.tuadventurecraft.lists;

import com.github.tumods.tuadventurecraft.Adventurecraft;
import com.github.tumods.tuadventurecraft.entities.blocks.ChairEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class EntityList {
    public static EntityType<?> CHAIR = EntityType.Builder.<ChairEntity>create((type, world) -> new ChairEntity(world), EntityClassification.MISC)
            .size(.0f, .0f)
            .setCustomClientFactory((spawnEntity, world) -> new ChairEntity(world))
            .build(Adventurecraft.modid)
            .setRegistryName(Adventurecraft.modid, "chair_entity");
}
