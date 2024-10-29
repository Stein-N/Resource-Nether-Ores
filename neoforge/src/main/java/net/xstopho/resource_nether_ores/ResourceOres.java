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
        OreConstants.commonInit();
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceNetherOresClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            BlockRegistry.BLOCKS.getEntries().forEach(registryObject -> {
                ItemBlockRenderTypes.setRenderLayer(registryObject.get(), RenderType.cutout());
            });
        }
    }
}
