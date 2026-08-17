package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_nether_ores.OreConstants;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.morthen.resource_nether_ores.registries.BlockRegistry.*;

public class BlockTagProv extends BlockTagsProvider {
    public BlockTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, OreConstants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addAll(List.of(
                        NETHER_COAL_ORE.get(), NETHER_COPPER_ORE.get(),
                        NETHER_IRON_ORE.get(), NETHER_DIAMOND_ORE.get(),
                        NETHER_EMERALD_ORE.get(), NETHER_LAPIS_ORE.get(),
                        NETHER_REDSTONE_ORE.get()
                ));

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .addAll(List.of(
                        NETHER_COAL_ORE.get(), NETHER_IRON_ORE.get(),
                        NETHER_LAPIS_ORE.get()));

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .addAll(List.of(
                        NETHER_REDSTONE_ORE.get(), NETHER_EMERALD_ORE.get(),
                        NETHER_DIAMOND_ORE.get()
                ));

        this.tag(Tags.Blocks.ORES_COAL).add(NETHER_COAL_ORE.get());
        this.tag(BlockTags.COPPER_ORES).add(NETHER_COPPER_ORE.get());
        this.tag(BlockTags.IRON_ORES).add(NETHER_IRON_ORE.get());
        this.tag(Tags.Blocks.ORES_DIAMOND).add(NETHER_DIAMOND_ORE.get());
        this.tag(Tags.Blocks.ORES_EMERALD).add(NETHER_EMERALD_ORE.get());
        this.tag(Tags.Blocks.ORES_LAPIS).add(NETHER_LAPIS_ORE.get());
        this.tag(Tags.Blocks.ORES_REDSTONE).add(NETHER_REDSTONE_ORE.get());
    }
}
