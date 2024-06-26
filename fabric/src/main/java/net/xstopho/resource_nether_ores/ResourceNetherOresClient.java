package net.xstopho.resource_nether_ores;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

public class ResourceNetherOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), BlockRegistry.NETHER_COAL_ORE.get(), BlockRegistry.NETHER_COPPER_ORE.get(), BlockRegistry.NETHER_IRON_ORE.get(),
                BlockRegistry.NETHER_DIAMOND_ORE.get(), BlockRegistry.NETHER_EMERALD_ORE.get(), BlockRegistry.NETHER_LAPIS_ORE.get(), BlockRegistry.NETHER_REDSTONE_ORE.get());

        FabricLoader.getInstance().getModContainer(OreConstants.MOD_ID).ifPresent(modContainer -> {
                    ResourceManagerHelper.registerBuiltinResourcePack(location("resource_nether_ores_x32"), modContainer, Component.literal("Resource Nether Ores x32"), ResourcePackActivationType.NORMAL);
                    ResourceManagerHelper.registerBuiltinResourcePack(location("resource_nether_ores_x64"), modContainer, Component.literal("Resource Nether Ores x64"), ResourcePackActivationType.NORMAL);
                });

    }

    private ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, path);
    }
}