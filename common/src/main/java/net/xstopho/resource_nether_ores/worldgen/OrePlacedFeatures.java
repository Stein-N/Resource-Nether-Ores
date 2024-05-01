package net.xstopho.resource_nether_ores.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.worldgen.util.OrePlacementUtil;

import java.util.List;

public class OrePlacedFeatures {

    public static final ResourceKey<PlacedFeature> NETHER_COAL_ORE_FEATURE = createKey("nether_coal_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_FEATURE = createKey("nether_copper_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND_ORE_FEATURE = createKey("nether_diamond_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_EMERALD_ORE_FEATURE = createKey("nether_emerald_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_ORE_FEATURE = createKey("nether_iron_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_LAPIS_ORE_FEATURE = createKey("nether_lapis_ore_feature");
    public static final ResourceKey<PlacedFeature> NETHER_REDSTONE_ORE_FEATURE = createKey("nether_redstone_ore_feature");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NETHER_COAL_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_COAL_ORE_KEY), common(20, 25, 115));
        register(context, NETHER_COPPER_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_COPPER_ORE_KEY), common(6, 25, 105));
        register(context, NETHER_DIAMOND_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_DIAMOND_ORE_KEY), common(3, 90, 125));
        register(context, NETHER_EMERALD_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_EMERALD_ORE_KEY), common(4, 25, 55));
        register(context, NETHER_IRON_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_IRON_ORE_KEY), common(40, 40, 110));
        register(context, NETHER_LAPIS_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_LAPIS_ORE_KEY), common(2, 30, 60));
        register(context, NETHER_REDSTONE_ORE_FEATURE, lookup.getOrThrow(OreConfiguredFeatures.NETHER_REDSTONE_ORE_KEY), common(8, 80, 115));
    }

    private static List<PlacementModifier> common(int count, int min, int max) {
        return OrePlacementUtil.commonOrePlacement(count, HeightRangePlacement.uniform(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max)));
    }

    private static ResourceKey<PlacedFeature> createKey(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(OreConstants.MOD_ID, id));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifer) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifer)));
    }
}
