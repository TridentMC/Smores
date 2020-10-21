package com.tridevmc.smores.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tridevmc.smores.init.WorldInit;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.util.Tuple;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// Shamelessly stolen from Habitus, another project I authored :)

public class BiomeFixer {
    private static final List<List<Tuple<Predicate<Biome>, Supplier<ConfiguredFeature<?, ?>>>>> FEATURE_LIST = Lists.newArrayList();

    private static final Predicate<Biome> ONLY_OVERWORLD =
            (b) -> b.getCategory() != Biome.Category.THEEND && b.getCategory() != Biome.Category.NETHER;
    private static final Predicate<Biome> ONLY_THE_END =
            (b) -> b.getCategory() == Biome.Category.THEEND;
    private static final Predicate<Biome> ONLY_NETHER =
            (b) -> b.getCategory() == Biome.Category.NETHER;

    static {
        for (GenerationStage.Decoration s : GenerationStage.Decoration.values()) {
            FEATURE_LIST.add(Lists.newArrayList());
        }
    }

    private static void addFeature(GenerationStage.Decoration stage, Predicate<Biome> predicate, ConfiguredFeature<?, ?> feature) {
        FEATURE_LIST.get(stage.ordinal()).add(new Tuple<>(predicate, () -> feature));
    }

    public static void registerFeatureHooks() {
        for(Map.Entry<Material, ConfiguredFeature<?, ?>> f : WorldInit.FEATURES.entrySet()) {
            // TODO: Handle the END here too!
            MaterialProperties.OreGenProperties properties = f.getKey().getProperties().getOreGen();
            addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, properties.dimension == MaterialProperties.Dimension.NETHER ? ONLY_NETHER : ONLY_OVERWORLD , f.getValue());
        }
    }

    public static void insertFeatures() {
        ForgeRegistries.BIOMES.forEach(b -> {
            List<List<Supplier<ConfiguredFeature<?, ?>>>> features = new ArrayList<>();
            b.getGenerationSettings().getFeatures().forEach(l -> features.add(Lists.newArrayList(l)));
            for (int i = 0; i < GenerationStage.Decoration.values().length; i++) {
                List<Tuple<Predicate<Biome>, Supplier<ConfiguredFeature<?, ?>>>> tuples = FEATURE_LIST.get(i);
                for (Tuple<Predicate<Biome>, Supplier<ConfiguredFeature<?, ?>>> tuple : tuples) {
                    if (tuple.getA().test(b)) {
                        features.get(i).add(tuple.getB());
                    }
                }
            }
            List<List<Supplier<ConfiguredFeature<?, ?>>>> bakedFeatures = ImmutableList.copyOf(features.stream().map(ImmutableList::copyOf).collect(Collectors.toList()));
            ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, b.getGenerationSettings(), bakedFeatures, "field_242484_f");
        });
    }
}