package com.github.tumods.tuadventurecraft.client;

import com.github.tumods.tuadventurecraft.entities.blocks.ChairEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ChairRenderer extends EntityRenderer<ChairEntity> {
    protected ChairRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ChairEntity chairEntity) {
        return null;
    }
}
