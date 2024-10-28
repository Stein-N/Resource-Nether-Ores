package net.xstopho.resource_nether_ores.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.worldgen.OreBiomeModifiers;
import net.xstopho.resource_nether_ores.worldgen.OreConfiguredFeatures;
import net.xstopho.resource_nether_ores.worldgen.OrePlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DataPackProv extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, OreConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, OrePlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, OreBiomeModifiers::bootstrap);

    public DataPackProv(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(OreConstants.MOD_ID));
    }
}
