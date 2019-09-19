package com.github.tumods.tuadventurecraft.world;

import com.github.tumods.tuadventurecraft.config.OregenConfig;
import com.github.tumods.tuadventurecraft.lists.BlockList;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.extensions.IForgeBlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Predicate;

public class OreGeneration {
    public static void setupOreGeneration() {
        // Select the biomes that the ores will generate in
        for (Biome biome : ForgeRegistries.BIOMES) {
            // Overworld Copper
            CountRangeConfig copper_ore_overworld_placement = new CountRangeConfig(OregenConfig.copper_ore_overworld_chance.get(), 20, 0, 75);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ore_overworld_copper.getDefaultState(), OregenConfig.copper_ore_overworld_size.get()),
                    Placement.COUNT_RANGE, copper_ore_overworld_placement));

            // Overworld Manganese
            CountRangeConfig manganese_ore_overworld_placement = new CountRangeConfig(OregenConfig.manganese_ore_overworld_chance.get(), 12, 0, 35);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ore_overworld_manganese.getDefaultState(), OregenConfig.manganese_ore_overworld_size.get()),
                    Placement.COUNT_RANGE, manganese_ore_overworld_placement));

            // Nether Manganesee
            CountRangeConfig manganese_ore_nether_placement = new CountRangeConfig(OregenConfig.manganese_ore_nether_chance.get(), 12, 0, 35);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockList.ore_nether_manganese.getDefaultState(), OregenConfig.manganese_ore_nether_size.get()),
                    Placement.COUNT_RANGE, manganese_ore_nether_placement));

            // End Neodymium //TODO: Implement FillerBlockType for ENDSTONE
//            CountRangeConfig neodymium_ore_end_placement = new CountRangeConfig(OregenConfig.neodymium_ore_end_chance.get(), 12, 0, 35);
//            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
//                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.valueOf("endstone"), BlockList.ore_end_neodymium.getDefaultState(), OregenConfig.neodymium_ore_end_size.get()),
//                    Placement.COUNT_RANGE, neodymium_ore_end_placement));

            // Overworld Silver
            CountRangeConfig silver_ore_overworld_placement = new CountRangeConfig(OregenConfig.silver_ore_overworld_chance.get(), 12, 0, 35);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ore_overworld_silver.getDefaultState(), OregenConfig.silver_ore_overworld_size.get()),
                    Placement.COUNT_RANGE, silver_ore_overworld_placement));

            // Overworld Tin
            CountRangeConfig tin_ore_overworld_placement = new CountRangeConfig(OregenConfig.tin_ore_overworld_chance.get(), 12, 0, 35);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE,
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ore_overworld_tin.getDefaultState(), OregenConfig.tin_ore_overworld_size.get()),
                    Placement.COUNT_RANGE, tin_ore_overworld_placement));
        }
    }
}
