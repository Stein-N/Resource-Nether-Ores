package net.xstopho.resource_nether_ores;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.xstopho.resource_nether_ores.worldgen.OrePlacedFeatures;

public class ResourceNetherOres implements ModInitializer {
    @Override
    public void onInitialize() {
        OreConstants.init();

        addFeature(OrePlacedFeatures.NETHER_COAL_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_COPPER_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_IRON_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_DIAMOND_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_EMERALD_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_LAPIS_ORE_FEATURE);
        addFeature(OrePlacedFeatures.NETHER_REDSTONE_ORE_FEATURE);
    }

    static void addFeature(ResourceKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, key);
    }
}
