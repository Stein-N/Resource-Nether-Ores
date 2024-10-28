package net.xstopho.resource_nether_ores;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceOres {

    public ResourceOres() {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceNetherOresClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            BlockRegistry.BLOCKS.getEntries().forEach(registryObject -> {
                ItemBlockRenderTypes.setRenderLayer(registryObject.get(), RenderType.cutout());
            });
        }

        @SubscribeEvent
        public static void registerResourcePacks(AddPackFindersEvent event) {
            event.addPackFinders(location("resource_nether_ores_x32"), PackType.CLIENT_RESOURCES, Component.literal("Resource Nether Ores x32"), PackSource.BUILT_IN, false, Pack.Position.TOP);
            event.addPackFinders(location("resource_nether_ores_x64"), PackType.CLIENT_RESOURCES, Component.literal("Resource Nether Ores x64"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        }

        private static ResourceLocation location(String id) {
            return ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, "resourcepacks/" + id);
        }
    }
}
