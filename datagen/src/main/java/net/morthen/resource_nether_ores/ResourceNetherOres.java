package net.morthen.resource_nether_ores;

import net.morthen.resource_nether_ores.provider.*;
import net.morthen.resource_nether_ores.registries.BlockRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres(IEventBus bus) {
        BlockRegistry.init();
    }

    @EventBusSubscriber(modid = OreConstants.MOD_ID)
    public static class Datagen {
        @SubscribeEvent
        public static void generate(GatherDataEvent.Client event) {
            event.createProvider(BlockLootProv::create);
            event.createBlockAndItemTags(BlockTagProv::new, ItemTagProv::new);
            event.createProvider(DataPackProv::new);
            event.createProvider(ModelProv::new);
        }
    }
}
