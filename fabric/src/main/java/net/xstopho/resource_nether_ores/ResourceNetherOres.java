package net.xstopho.resource_nether_ores;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

public class ResourceNetherOres implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }
}
