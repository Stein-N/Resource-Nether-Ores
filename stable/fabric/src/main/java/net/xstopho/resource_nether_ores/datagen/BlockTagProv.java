package net.xstopho.resource_nether_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.xstopho.resource_nether_ores.registries.BlockRegistry.*;

public class BlockTagProv extends FabricTagProvider.BlockTagProvider {
    public BlockTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(NETHER_COAL_ORE.get(), NETHER_COPPER_ORE.get(), NETHER_IRON_ORE.get(),
                        NETHER_DIAMOND_ORE.get(), NETHER_EMERALD_ORE.get(), NETHER_LAPIS_ORE.get(),
                        NETHER_REDSTONE_ORE.get());

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(NETHER_COAL_ORE.get(), NETHER_IRON_ORE.get(), NETHER_LAPIS_ORE.get());

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(NETHER_REDSTONE_ORE.get(), NETHER_EMERALD_ORE.get(), NETHER_DIAMOND_ORE.get());

        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(NETHER_COAL_ORE.get());
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(NETHER_COPPER_ORE.get());
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(NETHER_IRON_ORE.get());
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(NETHER_DIAMOND_ORE.get());
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(NETHER_EMERALD_ORE.get());
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(NETHER_LAPIS_ORE.get());
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(NETHER_REDSTONE_ORE.get());
    }
}
