package net.xstopho.resource_nether_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

import java.util.concurrent.CompletableFuture;

public class BlockLootProv extends FabricBlockLootTableProvider {


    public BlockLootProv(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.add(BlockRegistry.NETHER_COAL_ORE.get(), createOreDrop(BlockRegistry.NETHER_COAL_ORE.get(), Items.COAL));
        this.add(BlockRegistry.NETHER_COPPER_ORE.get(), createCopperOreDrops(BlockRegistry.NETHER_COPPER_ORE.get()));
        this.add(BlockRegistry.NETHER_IRON_ORE.get(), createOreDrop(BlockRegistry.NETHER_IRON_ORE.get(), Items.RAW_IRON));
        this.add(BlockRegistry.NETHER_DIAMOND_ORE.get(), createOreDrop(BlockRegistry.NETHER_DIAMOND_ORE.get(), Items.DIAMOND));
        this.add(BlockRegistry.NETHER_EMERALD_ORE.get(), createOreDrop(BlockRegistry.NETHER_EMERALD_ORE.get(), Items.EMERALD));
        this.add(BlockRegistry.NETHER_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistry.NETHER_LAPIS_ORE.get()));
        this.add(BlockRegistry.NETHER_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistry.NETHER_REDSTONE_ORE.get()));
    }
}
