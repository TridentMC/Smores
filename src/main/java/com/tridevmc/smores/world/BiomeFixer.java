package com.tridevmc.smores.world;

import com.google.common.collect.Lists;
import com.tridevmc.smores.init.WorldInit;
import com.tridevmc.smores.material.Material;
import com.tridevmc.smores.material.MaterialProperties;
import net.minecraft.util.Tuple;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Shamelessly stolen from Habitus, another project I authored :)
public class BiomeFixer {
    private static final List<List<Tuple<Predicate<Biome.Category>, Supplier<ConfiguredFeature<?, ?>>>>> FEATURE_LIST = Lists.newArrayList();

    private static final Predicate<Biome.Category> ONLY_OVERWORLD =
            (c) -> c != Biome.Category.THEEND && c != Biome.Category.NETHER;
    private static final Predicate<Biome.Category> ONLY_THE_END =
            (c) -> c == Biome.Category.THEEND;
    private static final Predicate<Biome.Category> ONLY_NETHER =
            (c) -> c == Biome.Category.NETHER;

    static {
        for (GenerationStage.Decoration s : GenerationStage.Decoration.values()) {
            FEATURE_LIST.add(Lists.newArrayList());
        }
    }

    private static void addFeature(GenerationStage.Decoration stage, Predicate<Biome.Category> predicate, ConfiguredFeature<?, ?> feature) {
        FEATURE_LIST.get(stage.ordinal()).add(new Tuple<>(predicate, () -> feature));
    }

    public static void registerFeatureHooks() {
        for (Map.Entry<Material, ConfiguredFeature<?, ?>> f : WorldInit.FEATURES.entrySet()) {
            MaterialProperties.OreGenProperties properties = f.getKey().getProperties().getOreGen();
            Predicate<Biome.Category> genPredicate =
                    properties.dimension == MaterialProperties.Dimension.NETHER ? ONLY_NETHER :
                            properties.dimension == MaterialProperties.Dimension.THE_END ? ONLY_THE_END :
                                    ONLY_OVERWORLD;
            addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, genPredicate, f.getValue());
        }
    }

    public static void onBiomeLoading(BiomeLoadingEvent evt) {
        for (GenerationStage.Decoration s : GenerationStage.Decoration.values()) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = evt.getGeneration().getFeatures(s);
            List<Tuple<Predicate<Biome.Category>, Supplier<ConfiguredFeature<?, ?>>>> tuples = FEATURE_LIST.get(s.ordinal());
            for (Tuple<Predicate<Biome.Category>, Supplier<ConfiguredFeature<?, ?>>> tuple : tuples) {
                if (tuple.getA().test(evt.getCategory())) {
                    features.add(tuple.getB());
                }
            }
        }
    }
}