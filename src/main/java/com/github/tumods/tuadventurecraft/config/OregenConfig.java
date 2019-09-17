package com.github.tumods.tuadventurecraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
    public static ForgeConfigSpec.IntValue copper_ore_overworld_chance;
    public static ForgeConfigSpec.IntValue copper_ore_overworld_size;
    public static ForgeConfigSpec.IntValue manganese_ore_overworld_chance;
    public static ForgeConfigSpec.IntValue manganese_ore_overworld_size;
    public static ForgeConfigSpec.IntValue manganese_ore_nether_chance;
    public static ForgeConfigSpec.IntValue manganese_ore_nether_size;
    public static ForgeConfigSpec.IntValue neodymium_ore_end_chance;
    public static ForgeConfigSpec.IntValue neodymium_ore_end_size;
    public static ForgeConfigSpec.IntValue silver_ore_overworld_chance;
    public static ForgeConfigSpec.IntValue silver_ore_overworld_size;
    public static ForgeConfigSpec.IntValue tin_ore_overworld_chance;
    public static ForgeConfigSpec.IntValue tin_ore_overworld_size;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("Oregen Config");

        copper_ore_overworld_chance = server
                .comment("Maximum number of copper ore veins that can spawn in a single chunk of the overworld")
                .comment("[1-100]")
                .defineInRange("oregen.overworld_copper_ore_chance", 10, 1, 100);

        copper_ore_overworld_size = server
                .comment("Maximum number of ore blocks in an overworld copper vein")
                .comment("[1-30]")
                .defineInRange("oregen.overworld_copper_vein_size", 8, 1, 30);

        manganese_ore_overworld_chance = server
                .comment("Maximum number of manganese ore veins that can spawn in a single chunk of the overworld")
                .comment("[1-100]")
                .defineInRange("oregen.overworld_manganese_ore_chance", 7, 1, 100);

        manganese_ore_overworld_size = server
                .comment("Maximum number of ore blocks in an overworld manganese vein")
                .comment("[1-30")
                .defineInRange("oregen.overworld_manganese_vein_size", 6, 1, 30);

        manganese_ore_nether_chance = server
                .comment("Maximum number of manganese ore veins that can spawn in a single chunk of the nether")
                .comment("[1-100]")
                .defineInRange("oregen.nether_manganese_ore_chance", 10, 1, 100);

        manganese_ore_nether_size = server
                .comment("Maximum number of ore blocks in a nether manganese vein")
                .comment("[1-30]")
                .defineInRange("oregen.nether_manganese_vein_size", 8, 1, 30);

        neodymium_ore_end_chance = server
                .comment("Maximum number of neodymium ore veins that can spawn in a single chunk of the end")
                .comment("[1-100]")
                .defineInRange("oregen.end_neodymium_ore_chance", 10, 1, 100);

        neodymium_ore_end_size = server
                .comment("Maximum number of ore blocks in an end neodymium vein")
                .comment("[1-30]")
                .defineInRange("oregen.end_neodymium_vein_size", 6, 1, 30);

        silver_ore_overworld_chance = server
                .comment("Maximum number of silver ore veins that can spawn in a single chunk of the overworld")
                .comment("[1-100]")
                .defineInRange("oregen.overworld_silver_ore_chance", 10, 1, 100);

        silver_ore_overworld_size = server
                .comment("Maximum number of ore blocks in an overworld silver vein")
                .comment("[1-30]")
                .defineInRange("oregen.overworld_silver_vein_size", 4, 1, 30);

        tin_ore_overworld_chance = server
                .comment("Maximum number of tin ore veins that can spawn in a single chunk of the overworld")
                .comment("[1-100]")
                .defineInRange("oregen.overworld_tin_ore_chance", 10, 1, 100);

        tin_ore_overworld_size = server
                .comment("Maximum number of ore blocks in an overworld tin vein")
                .comment("[1-30]")
                .defineInRange("oregen.overworld_tin_vein_size", 7, 1, 30);
    }
}
