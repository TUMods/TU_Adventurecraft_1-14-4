package com.github.tumods.tuadventurecraft.world;

import com.github.tumods.tuadventurecraft.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
    public static void setupOreGeneration() {
        // Select the biomes that the ores will generate in
        for (Biome biome : ForgeRegistries.BIOMES) {
            CountRangeConfig copper_ore_placement = new CountRangeConfig(15, 20, 20, 75);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ore_overworld_copper.getDefaultState(), 8),
                    Placement.COUNT_RANGE, copper_ore_placement));


        }
    }
}
