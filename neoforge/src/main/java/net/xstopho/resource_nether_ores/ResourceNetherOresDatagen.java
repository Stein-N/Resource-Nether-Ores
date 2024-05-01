package net.xstopho.resource_nether_ores;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.resource_nether_ores.datagen.*;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ResourceNetherOresDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ModelProv(output, fileHelper));
        gen.addProvider(event.includeServer(), BlockLootProv.create(output, provider));
        gen.addProvider(event.includeServer(), new DataPackProv(output, provider));

        BlockTagProv blockTags = gen.addProvider(event.includeServer(), new BlockTagProv(output, provider, fileHelper));
        gen.addProvider(event.includeServer(), new ItemTagProv(output, provider, blockTags.contentsGetter(), fileHelper));
    }
}
