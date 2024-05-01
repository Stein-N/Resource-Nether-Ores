package net.xstopho.resource_nether_ores.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.List;

public class OreConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = createKey("nether_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = createKey("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = createKey("nether_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = createKey("nether_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = createKey("nether_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LAPIS_ORE_KEY = createKey("nether_lapis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE_KEY = createKey("nether_redstone_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_COAL_ORE, 17));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_COPPER_ORE, 8));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_DIAMOND_ORE, 8));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_EMERALD_ORE, 7));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_IRON_ORE, 8));
        register(context, NETHER_LAPIS_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_LAPIS_ORE, 7));
        register(context, NETHER_REDSTONE_ORE_KEY, Feature.ORE, getConfig(BlockRegistry.NETHER_REDSTONE_ORE, 8));
    }

    private static OreConfiguration getConfig(RegistryObject<Block> block, int size) {
        List<OreConfiguration.TargetBlockState> list = List.of(OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), block.get().defaultBlockState()));
        return new OreConfiguration(list, size);
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(OreConstants.MOD_ID, id));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
