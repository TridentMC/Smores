package com.tridevmc.smores;

import com.tridevmc.smores.event.MaterialRegistrationEvent;
import com.tridevmc.smores.init.BlocksInit;
import com.tridevmc.smores.init.ItemsInit;
import com.tridevmc.smores.init.MaterialsInit;
import com.tridevmc.smores.material.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Smores.MODID)
public class Smores
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "smores";
    public static final ResourceLocation MATERIAL_REGISTRY_NAME = new ResourceLocation(Smores.MODID, "materials");
    public static final SmoresItemGroup SMORES_ITEM_GROUP = new SmoresItemGroup();
    public Smores() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        BlocksInit.setupRenderLayers();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }



    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> evt) {
            BlocksInit.registerBlocks(evt);
        }

        @SubscribeEvent
        public static void onItemColorRegistry(final ColorHandlerEvent.Item evt) {
            ItemsInit.setupColors(evt.getItemColors());
            BlocksInit.setupItemBlockColors(evt.getItemColors());
        }

        @SubscribeEvent
        public static void onBlockColorRegistry(final ColorHandlerEvent.Block evt) {
            BlocksInit.setupBlockColors(evt.getBlockColors());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> evt) {
            ItemsInit.registerItems(evt);
            BlocksInit.registerItemBlocks(evt);
        }

        @SubscribeEvent
        public static void onMaterialRegistry(final MaterialRegistrationEvent evt) {
            MaterialsInit.registerMaterials(evt);
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        @SubscribeEvent
        public static void onRegistryCreation(final RegistryEvent.NewRegistry evt) {
            IForgeRegistry<Material> mat = new RegistryBuilder()
                    .setName(MATERIAL_REGISTRY_NAME)
                    .setType(Material.class)
                    .create();
            ModLoader.get().postEvent(new MaterialRegistrationEvent(mat));
            ((ForgeRegistry)mat).freeze();
        }

    }
}
