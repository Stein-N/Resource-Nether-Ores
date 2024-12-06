package net.xstopho.resource_nether_ores;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_nether_ores.datagen.*;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ResourceOresDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        event.createProvider(BlockLootProvider::create);
        event.createProvider(DataPackProvider::new);
        event.createProvider(ModelsProvider::new);

        BlockTagProvider provider = event.addProvider(new BlockTagProvider(output, lookupProvider, helper));
        event.addProvider(new ItemTagsProvider(output, lookupProvider, provider.contentsGetter(), helper));
    }
}
