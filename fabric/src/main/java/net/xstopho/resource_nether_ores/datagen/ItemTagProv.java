package net.xstopho.resource_nether_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.xstopho.resourcelibrary.items.tags.TagHelper;

import java.util.concurrent.CompletableFuture;

import static net.xstopho.resource_nether_ores.registries.BlockRegistry.*;

public class ItemTagProv extends FabricTagProvider.ItemTagProvider {
    public ItemTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ores"))
                .add(NETHER_COAL_ORE.get().asItem(), NETHER_COPPER_ORE.get().asItem(), NETHER_IRON_ORE.get().asItem(),
                        NETHER_DIAMOND_ORE.get().asItem(), NETHER_EMERALD_ORE.get().asItem(), NETHER_LAPIS_ORE.get().asItem(),
                        NETHER_REDSTONE_ORE.get().asItem());

        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/coal")).add(NETHER_COAL_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/copper")).add(NETHER_COPPER_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/iron")).add(NETHER_IRON_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/diamond")).add(NETHER_DIAMOND_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/emerald")).add(NETHER_EMERALD_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/lapis")).add(NETHER_LAPIS_ORE.get().asItem());
        getOrCreateTagBuilder(TagHelper.createPlatformTag("ore/redstone")).add(NETHER_REDSTONE_ORE.get().asItem());
    }
}
