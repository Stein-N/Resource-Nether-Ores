package net.xstopho.resource_nether_ores.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.worldgen.util.OrePlacementUtil;

import java.util.ArrayList;
import java.util.List;

public class OrePlacedFeatures {

    public static final List<ResourceKey<PlacedFeature>> PLACED_FEATURES = new ArrayList<>();

    public static final ResourceKey<PlacedFeature> NETHER_COAL_ORE_FEATURE = createKey("nether_coal_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_FEATURE = createKey("nether_copper_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND_ORE_FEATURE = createKey("nether_diamond_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_EMERALD_ORE_FEATURE = createKey("nether_emerald_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_ORE_FEATURE = createKey("nether_iron_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_LAPIS_ORE_FEATURE = createKey("nether_lapis_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_REDSTONE_ORE_FEATURE = createKey("nether_redstone_ore_feature");

    public static final ResourceKey<PlacedFeature> BASALT_COAL_ORE_FEATURE = createKey("basalt_coal_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_COPPER_ORE_FEATURE = createKey("basalt_copper_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_DIAMOND_ORE_FEATURE = createKey("basalt_diamond_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_EMERALD_ORE_FEATURE = createKey("basalt_emerald_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_IRON_ORE_FEATURE = createKey("basalt_iron_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_LAPIS_ORE_FEATURE = createKey("basalt_lapis_ore_feature");
    public static final ResourceKey<PlacedFeature> BASALT_REDSTONE_ORE_FEATURE = createKey("basalt_redstone_ore_feature");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NETHER_COAL_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_COAL_ORE_KEY), common(15, 25, 115));
        register(context, NETHER_COPPER_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_COPPER_ORE_KEY), common(5, 25, 105));
        register(context, NETHER_DIAMOND_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_DIAMOND_ORE_KEY), common(3, 90, 125));
        register(context, NETHER_EMERALD_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_EMERALD_ORE_KEY), common(4, 25, 55));
        register(context, NETHER_IRON_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_IRON_ORE_KEY), common(30, 40, 110));
        register(context, NETHER_LAPIS_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_LAPIS_ORE_KEY), common(2, 30, 60));
        register(context, NETHER_REDSTONE_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_REDSTONE_ORE_KEY), common(6, 80, 115));

        register(context, BASALT_COAL_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_COAL_ORE_KEY), common(8, 25, 115));
        register(context, BASALT_COPPER_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_COPPER_ORE_KEY), common(3, 25, 105));
        register(context, BASALT_DIAMOND_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_DIAMOND_ORE_KEY), common(2, 90, 125));
        register(context, BASALT_EMERALD_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_EMERALD_ORE_KEY), common(2, 25, 55));
        register(context, BASALT_IRON_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_IRON_ORE_KEY), common(15, 40, 110));
        register(context, BASALT_LAPIS_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_LAPIS_ORE_KEY), common(1, 30, 60));
        register(context, BASALT_REDSTONE_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.BASALT_REDSTONE_ORE_KEY), common(4, 80, 115));
    }

    private static List<PlacementModifier> common(int veinAmountPerChunk, int minHeight, int maxHeight) {
        return OrePlacementUtil.commonOrePlacement(veinAmountPerChunk, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)));
    }

    private static ResourceKey<PlacedFeature> createKey(String id) {
        ResourceKey<PlacedFeature> feature = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, id));
        PLACED_FEATURES.add(feature);
        return feature;
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifer) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifer)));
    }
}
