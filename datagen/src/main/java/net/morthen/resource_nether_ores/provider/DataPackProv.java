package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.morthen.resource_nether_ores.OreConstants;
import net.morthen.resource_nether_ores.worldgen.OreConfiguredFeatures;
import net.morthen.resource_nether_ores.worldgen.OrePlacedFeatures;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DataPackProv extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, OreConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, OrePlacedFeatures::bootstrap);

    public DataPackProv(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(OreConstants.MOD_ID));
    }
}
