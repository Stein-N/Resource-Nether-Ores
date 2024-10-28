package net.xstopho.resource_nether_ores.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OreBiomeModifications {

    public static void init() {
        OrePlacedFeatures.PLACED_FEATURES.forEach(OreBiomeModifications::addFeature);
    }

    static void addFeature(ResourceKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, key);
    }
}
