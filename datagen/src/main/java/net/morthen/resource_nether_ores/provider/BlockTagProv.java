package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_nether_ores.OreConstants;
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
                        NETHER_COAL_ORE.getResourceKey(), NETHER_COPPER_ORE.getResourceKey(),
                        NETHER_IRON_ORE.getResourceKey(), NETHER_DIAMOND_ORE.getResourceKey(),
                        NETHER_EMERALD_ORE.getResourceKey(), NETHER_LAPIS_ORE.getResourceKey(),
                        NETHER_REDSTONE_ORE.getResourceKey()
                ));

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .addAll(List.of(
                        NETHER_COAL_ORE.getResourceKey(), NETHER_IRON_ORE.getResourceKey(),
                        NETHER_LAPIS_ORE.getResourceKey()));

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .addAll(List.of(
                        NETHER_REDSTONE_ORE.getResourceKey(), NETHER_EMERALD_ORE.getResourceKey(),
                        NETHER_DIAMOND_ORE.getResourceKey()
                ));

        this.tag(create("ore/coal")).add(NETHER_COAL_ORE.getResourceKey());
        this.tag(BlockTags.COPPER_ORES).add(NETHER_COPPER_ORE.getResourceKey());
        this.tag(BlockTags.IRON_ORES).add(NETHER_IRON_ORE.getResourceKey());
        this.tag(create("ore/diamond")).add(NETHER_DIAMOND_ORE.getResourceKey());
        this.tag(create("ore/emerald")).add(NETHER_EMERALD_ORE.getResourceKey());
        this.tag(create("ore/lapis")).add(NETHER_LAPIS_ORE.getResourceKey());
        this.tag(create("ore/redstone")).add(NETHER_REDSTONE_ORE.getResourceKey());
    }

    private TagKey<Block> create(String path) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", path));
    }
}
