package com.github.tumods.tuadventurecraft;

import com.github.tumods.tuadventurecraft.itemgroup.AdventurecraftBlocks;
import com.github.tumods.tuadventurecraft.itemgroup.AdventurecraftItems;
import com.github.tumods.tuadventurecraft.itemtypes.HoshickItem;
import com.github.tumods.tuadventurecraft.itemtypes.KnifeItem;
import com.github.tumods.tuadventurecraft.lists.BlockList;
import com.github.tumods.tuadventurecraft.lists.ItemList;
import com.github.tumods.tuadventurecraft.lists.ToolMaterialList;
import com.github.tumods.tuadventurecraft.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("tuadventurecraft")
public class Adventurecraft {
    private static Adventurecraft instance;
    public static final String modid = "tuadventurecraft";
    private static final Logger logger = LogManager.getLogger(modid);

    public static final ItemGroup ADVENTURECRAFT_ITEMS = new AdventurecraftItems();
    public static final ItemGroup ADVENTURECRAFT_BLOCKS = new AdventurecraftBlocks();

    public Adventurecraft() {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // Pre-init function
    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Pre-init setup...");
        OreGeneration.setupOreGeneration();
    }

    // Client-side registration
    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client-side setup...");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            logger.info("Registering items...");

            event.getRegistry().registerAll(
                    // Items
                    ItemList.ingot_copper = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("ingot_copper")),
                    ItemList.ingot_neodymium = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("ingot_neodymium")),
                    ItemList.ingot_silver = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("ingot_silver")),
                    ItemList.ingot_tin = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("ingot_tin")),
                    ItemList.oreshard_overworld_copper = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_overworld_copper")),
                    ItemList.oreshard_overworld_iron = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_overworld_iron")),
                    ItemList.oreshard_nether_manganese = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_nether_manganese")),
                    ItemList.oreshard_overworld_manganese = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_overworld_manganese")),
                    ItemList.oreshard_end_neodymium = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_end_neodymium")),
                    ItemList.oreshard_overworld_silver = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_overworld_silver")),
                    ItemList.oreshard_overworld_tin = new Item(new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("oreshard_overworld_tin")),

                    // Tools
                    ItemList.hatchet_flint = new AxeItem(ToolMaterialList.flint, 2.0f, -2.2f,
                            new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("hatchet_flint")),
                    ItemList.hoshick_flint = new HoshickItem(ToolMaterialList.flint, 0, -1.0f,
                            new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("hoshick_flint")),
                    ItemList.knife_flint = new KnifeItem(ToolMaterialList.flint, -1, 1.2f,
                            new Item.Properties().group(ADVENTURECRAFT_ITEMS)).setRegistryName(location("knife_flint")),

                    // ItemBlocks
                    ItemList.block_copper = new BlockItem(BlockList.block_copper, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.block_copper.getRegistryName()),
                    ItemList.ore_end_neodymium = new BlockItem(BlockList.ore_end_neodymium, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_end_neodymium.getRegistryName()),
                    ItemList.ore_nether_manganese = new BlockItem(BlockList.ore_nether_manganese, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_nether_manganese.getRegistryName()),
                    ItemList.ore_overworld_copper = new BlockItem(BlockList.ore_overworld_copper, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_overworld_copper.getRegistryName()),
                    ItemList.ore_overworld_manganese = new BlockItem(BlockList.ore_overworld_manganese, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_overworld_manganese.getRegistryName()),
                    ItemList.ore_overworld_silver = new BlockItem(BlockList.ore_overworld_silver, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_overworld_silver.getRegistryName()),
                    ItemList.ore_overworld_tin = new BlockItem(BlockList.ore_overworld_tin, new Item.Properties().group(ADVENTURECRAFT_BLOCKS))
                            .setRegistryName(BlockList.ore_overworld_tin.getRegistryName())
            );
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            logger.info("Registering blocks...");

            event.getRegistry().registerAll(
                    // Metals
                    BlockList.block_copper = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3f,6f).sound(SoundType.METAL))
                            .setRegistryName(location("block_copper")),


                    // Ores
                    BlockList.ore_end_neodymium = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3f, 9f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_end_neodymium")),
                    BlockList.ore_nether_manganese = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f,6f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_nether_manganese")),
                    BlockList.ore_overworld_copper = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_overworld_copper")),
                    BlockList.ore_overworld_manganese = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 4f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_overworld_manganese")),
                    BlockList.ore_overworld_silver = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3f,6f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_overworld_silver")),
                    BlockList.ore_overworld_tin = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.f, 4.f).sound(SoundType.STONE))
                            .setRegistryName(location("ore_overworld_tin"))
            );
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }

    public static Adventurecraft getInstance() { return instance; }
}
