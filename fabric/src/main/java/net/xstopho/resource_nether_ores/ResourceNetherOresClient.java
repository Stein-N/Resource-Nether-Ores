package net.xstopho.resource_nether_ores;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

public class ResourceNetherOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRegistry.BLOCKS.getEntries().forEach(registryObject -> {
            BlockRenderLayerMap.INSTANCE.putBlock(registryObject.get(), RenderType.cutout());
        });
    }
}