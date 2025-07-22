package net.xstopho.resource_nether_ores;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceOres {

    public ResourceOres() {
        OreConstants.init();
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceNetherOresClient {

        @SubscribeEvent
        @SuppressWarnings("all")
        public static void renderSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_COAL_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_COPPER_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_IRON_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_DIAMOND_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_EMERALD_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_LAPIS_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_REDSTONE_ORE.get(), RenderType.cutout());
        }
    }
}
