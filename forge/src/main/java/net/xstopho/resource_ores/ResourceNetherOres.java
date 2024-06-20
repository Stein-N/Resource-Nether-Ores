package net.xstopho.resource_ores;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.client.ResourcePackHelper;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres() {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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

            ResourcePackHelper.extractPack("Resource Nether Ores x32");
            ResourcePackHelper.extractPack("Resource Nether Ores x64");
        }
    }
}
