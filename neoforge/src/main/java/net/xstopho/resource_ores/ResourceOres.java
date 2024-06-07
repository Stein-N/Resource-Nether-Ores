package net.xstopho.resource_ores;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceOres {

    public ResourceOres(IEventBus bus) {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceNetherOresClient {

        @SubscribeEvent
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
