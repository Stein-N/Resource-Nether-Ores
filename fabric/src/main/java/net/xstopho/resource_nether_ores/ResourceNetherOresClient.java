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

        BlockRegistry.BLOCKS.getEntries().forEach(registryObject -> {
            BlockRenderLayerMap.INSTANCE.putBlock(registryObject.get(), RenderType.cutout());
        });

        FabricLoader.getInstance().getModContainer(OreConstants.MOD_ID).ifPresent(modContainer -> {
                    ResourceManagerHelper.registerBuiltinResourcePack(location("resource_nether_ores_x32"), modContainer, Component.literal("Resource Nether Ores x32"), ResourcePackActivationType.NORMAL);
                    ResourceManagerHelper.registerBuiltinResourcePack(location("resource_nether_ores_x64"), modContainer, Component.literal("Resource Nether Ores x64"), ResourcePackActivationType.NORMAL);
                });

    }

    private ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, path);
    }
}