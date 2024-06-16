package net.xstopho.resource_ores.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BlockLootProv extends BlockLootSubProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootProv::new, LootContextParamSets.BLOCK)), provider);
    }

    protected BlockLootProv(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(BlockRegistry.NETHER_COAL_ORE.get(), createOreDrop(BlockRegistry.NETHER_COAL_ORE.get(), Items.COAL));
        this.add(BlockRegistry.NETHER_COPPER_ORE.get(), createCopperOreDrops(BlockRegistry.NETHER_COPPER_ORE.get()));
        this.add(BlockRegistry.NETHER_IRON_ORE.get(), createOreDrop(BlockRegistry.NETHER_IRON_ORE.get(), Items.RAW_IRON));
        this.add(BlockRegistry.NETHER_DIAMOND_ORE.get(), createOreDrop(BlockRegistry.NETHER_DIAMOND_ORE.get(), Items.DIAMOND));
        this.add(BlockRegistry.NETHER_EMERALD_ORE.get(), createOreDrop(BlockRegistry.NETHER_EMERALD_ORE.get(), Items.EMERALD));
        this.add(BlockRegistry.NETHER_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistry.NETHER_LAPIS_ORE.get()));
        this.add(BlockRegistry.NETHER_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistry.NETHER_REDSTONE_ORE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
