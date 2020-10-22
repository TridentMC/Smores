package com.tridevmc.smores.init;

import com.google.common.collect.Maps;
import com.tridevmc.smores.Smores;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.Map;

public class WorldInit {

    public static final Map<Material, ConfiguredFeature<?, ?>> FEATURES = Maps.newHashMap();
    public static final Map<MaterialProperties.Dimension, RuleTest> RULES = Maps.newHashMap();

    static {
        RULES.put(MaterialProperties.Dimension.OVERWORLD, new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD));
        RULES.put(MaterialProperties.Dimension.NETHER, new BlockMatchRuleTest(Blocks.NETHERRACK));
        RULES.put(MaterialProperties.Dimension.THE_END, new BlockMatchRuleTest(Blocks.END_STONE));
    }

    public static void registerConfiguredFeatures() {
        IForgeRegistry<Material> mats = RegistryManager.ACTIVE.getRegistry(Material.class);

        for (Material mat : mats.getValues()) {
            if (mat.getProperties().getOreGen() != null) {
                MaterialProperties.OreGenProperties oreGenProperties = mat.getProperties().getOreGen();
                RuleTest fillerBlockType = RULES.get(oreGenProperties.dimension);
                ConfiguredFeature<?, ?> feature = Feature.ORE.withConfiguration(
                        new OreFeatureConfig(fillerBlockType,
                                BlocksInit.ORES
                                        .get(mat)
                                        .getDefaultState(),
                                oreGenProperties.size))
                        .withPlacement(Placement.field_242907_l
                                .configure(new TopSolidRangeConfig(
                                        oreGenProperties.minHeight,
                                        oreGenProperties.minHeight,
                                        oreGenProperties.maxHeight)))
                        .func_242728_a()
                        .func_242731_b(oreGenProperties.count);
                FEATURES.put(mat, feature);
                Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Smores.MODID + "_ore_" + mat.getRegistryName().getPath(), feature);
            }
        }
    }
}
