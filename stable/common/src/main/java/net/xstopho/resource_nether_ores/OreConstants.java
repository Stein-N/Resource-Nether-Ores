package net.xstopho.resource_nether_ores;

import net.minecraft.resources.ResourceLocation;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;
import net.xstopho.resourcelibrary.registration.ResourcePackRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OreConstants {
    public static final String MOD_ID = "resource_nether_ores";
    public static final String MOD_NAME = "Resource Nether Ores";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        BlockRegistry.init();
        CreativeTabRegistry.init();

        ResourcePackRegistry resourcePackRegistry = ResourcePackRegistry.getInstance(MOD_ID);
        resourcePackRegistry.register(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resource_nether_ores_x32"), "Resource Nether Ores x32");
        resourcePackRegistry.register(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resource_nether_ores_x64"), "Resource Nether Ores x64");
    }
}
