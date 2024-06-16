package net.xstopho.resource_ores.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.worldgen.OrePlacedFeatures;

public class OreBiomeModifiers {

    private static BootstrapContext<BiomeModifier> contextModifier;

    public static final ResourceKey<BiomeModifier> ADD_NETHER_COAL_ORE = createKey("add_nether_coal_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORE = createKey("add_nether_copper_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_DIAMOND_ORE = createKey("add_nether_diamond_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_EMERALD_ORE = createKey("add_nether_emerald_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON_ORE = createKey("add_nether_iron_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_LAPIS_ORE = createKey("add_nether_lapis_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_REDSTONE_ORE = createKey("add_nether_redstone_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        contextModifier = context;

        addModifier(ADD_NETHER_COAL_ORE, OrePlacedFeatures.NETHER_COAL_ORE_FEATURE);
        addModifier(ADD_NETHER_COPPER_ORE, OrePlacedFeatures.NETHER_COPPER_ORE_FEATURE);
        addModifier(ADD_NETHER_DIAMOND_ORE, OrePlacedFeatures.NETHER_DIAMOND_ORE_FEATURE);
        addModifier(ADD_NETHER_EMERALD_ORE, OrePlacedFeatures.NETHER_EMERALD_ORE_FEATURE);
        addModifier(ADD_NETHER_IRON_ORE, OrePlacedFeatures.NETHER_IRON_ORE_FEATURE);
        addModifier(ADD_NETHER_LAPIS_ORE, OrePlacedFeatures.NETHER_LAPIS_ORE_FEATURE);
        addModifier(ADD_NETHER_REDSTONE_ORE, OrePlacedFeatures.NETHER_REDSTONE_ORE_FEATURE);
    }

    private static void addModifier(ResourceKey<BiomeModifier> modifier, ResourceKey<PlacedFeature> feature) {
        contextModifier.register(modifier, new BiomeModifiers.AddFeaturesBiomeModifier(
                contextModifier.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(contextModifier.lookup(Registries.PLACED_FEATURE).getOrThrow(feature)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> createKey(String id) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, id));
    }
}
