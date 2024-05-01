package net.xstopho.resource_nether_ores;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.xstopho.resource_nether_ores.datagen.BlockLootProv;
import net.xstopho.resource_nether_ores.datagen.ModelProv;
import net.xstopho.resource_nether_ores.datagen.WorldGenProv;
import net.xstopho.resource_nether_ores.worldgen.OreConfiguredFeatures;
import net.xstopho.resource_nether_ores.worldgen.OrePlacedFeatures;

public class ResourceNetherOresDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelProv::new);
        pack.addProvider(BlockLootProv::new);
        pack.addProvider(WorldGenProv::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, OreConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, OrePlacedFeatures::bootstrap);
    }
}
