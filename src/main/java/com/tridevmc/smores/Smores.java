package com.tridevmc.smores;

import com.tridevmc.smores.client.CommonProxy;
import com.tridevmc.smores.client.color.FogColorizer;
import com.tridevmc.smores.event.MaterialRegistrationEvent;
import com.tridevmc.smores.init.*;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.world.BiomeFixer;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Smores.MODID)
public class Smores {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "smores";
    public static final ResourceLocation MATERIAL_REGISTRY_NAME = new ResourceLocation(Smores.MODID, "materials");
    public static final SmoresItemGroup SMORES_ITEM_GROUP = new SmoresItemGroup();
    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> com.tridevmc.smores.client.ClientProxy::new, () -> CommonProxy::new);

    public Smores() {
        FMLJavaModLoadingContext.get().getModEventBus().register(PROXY);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        WorldInit.registerConfiguredFeatures();
        BiomeFixer.registerFeatureHooks();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        PROXY.setupRenderTypes();
        MinecraftForge.EVENT_BUS.register(new FogColorizer());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onBiomeLoading(BiomeLoadingEvent evt) {
        BiomeFixer.onBiomeLoading(evt);
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onFluidsRegistry(final RegistryEvent.Register<Fluid> evt) {
            FluidsInit.registerFluids(evt);
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> evt) {
            BlocksInit.registerBlocks(evt);
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
            ((ForgeRegistry) mat).freeze();
        }

    }
}
