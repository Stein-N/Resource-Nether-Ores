package net.xstopho.resource_nether_ores;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_nether_ores.provider.*;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

import java.util.concurrent.CompletableFuture;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres(IEventBus bus) {
        BlockRegistry.init();
    }

    @EventBusSubscriber(modid = OreConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class Datagen {
        @SubscribeEvent
        public static void generate(GatherDataEvent event) {
            DataGenerator gen = event.getGenerator();
            PackOutput output = gen.getPackOutput();
            CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
            ExistingFileHelper helper = event.getExistingFileHelper();

            gen.addProvider(event.includeServer(), new ModelProv(output, helper));
            gen.addProvider(event.includeServer(), new DataPackProv(output, provider));
            gen.addProvider(event.includeServer(), BlockLootProv.create(output, provider));

            BlockTagProv blockTags = gen.addProvider(event.includeServer(), new BlockTagProv(output, provider, helper));
            gen.addProvider(event.includeServer(), new ItemTagProv(output, provider, blockTags.contentsGetter(), helper));
        }
    }
}
