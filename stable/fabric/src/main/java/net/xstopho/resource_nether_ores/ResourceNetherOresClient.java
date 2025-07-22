package net.xstopho.resource_nether_ores;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

public class ResourceNetherOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), BlockRegistry.NETHER_COAL_ORE.get(), BlockRegistry.NETHER_COPPER_ORE.get(), BlockRegistry.NETHER_IRON_ORE.get(),
                BlockRegistry.NETHER_DIAMOND_ORE.get(), BlockRegistry.NETHER_EMERALD_ORE.get(), BlockRegistry.NETHER_LAPIS_ORE.get(), BlockRegistry.NETHER_REDSTONE_ORE.get());
    }
}