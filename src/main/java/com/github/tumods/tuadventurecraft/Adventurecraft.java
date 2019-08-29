package com.github.tumods.tuadventurecraft;

import com.github.tumods.tuadventurecraft.itemgroup.AdventurecraftBlocks;
import com.github.tumods.tuadventurecraft.itemgroup.AdventurecraftItems;
import com.github.tumods.tuadventurecraft.lists.BlockList;
import com.github.tumods.tuadventurecraft.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

                    // ItemBlocks
                    ItemList.block_copper = new BlockItem(BlockList.block_copper, new Item.Properties().group(ADVENTURECRAFT_BLOCKS)).setRegistryName(BlockList.block_copper.getRegistryName())
            );
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            logger.info("Registering blocks...");

            event.getRegistry().registerAll(
                    BlockList.block_copper = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.METAL))
                            .setRegistryName(location("block_copper"))
            );
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }

    public static Adventurecraft getInstance() { return instance; }
}
