package com.tridevmc.smores.init;

import com.google.common.collect.Maps;
import com.tridevmc.smores.Smores;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.Map;

public class WorldInit {
    public static final Map<Material, ConfiguredFeature<?,?> > FEATURES = Maps.newHashMap();

    public static void registerConfiguredFeatures() {
        IForgeRegistry<Material> mats = RegistryManager.ACTIVE.getRegistry(Material.class);

        for (Material mat : mats.getValues()) {
            if(mat.getProperties().getOreGen() != null) {
                // TODO: Figure out end generation?
                MaterialProperties.OreGenProperties oreGenProperties = mat.getProperties().getOreGen();
                RuleTest fillerBlockType = oreGenProperties.dimension == MaterialProperties.Dimension.NETHER ? OreFeatureConfig.FillerBlockType.field_241883_b : OreFeatureConfig.FillerBlockType.field_241882_a;
                // Hooray for obfuscated methods!
                // Seriously - the codecs help, but I'm just guessing at this point.
                ConfiguredFeature<?,?> feature = Feature.ORE.withConfiguration(new OreFeatureConfig(fillerBlockType,
                        BlocksInit.ORES.get(mat).getDefaultState(),
                        oreGenProperties.size))
                        .withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(oreGenProperties.minHeight, oreGenProperties.minHeight, oreGenProperties.maxHeight)))
                        .func_242728_a()
                        .func_242731_b(oreGenProperties.count);
                FEATURES.put(mat, feature);
                Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Smores.MODID + "_ore_" + mat.getRegistryName().getPath(), feature);
            }
        }
    }
}
