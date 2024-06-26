package net.xstopho.resource_nether_ores.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resource_nether_ores.OreConstants;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.xstopho.resource_nether_ores.registries.BlockRegistry.*;
import static net.xstopho.resource_nether_ores.registries.BlockRegistry.NETHER_REDSTONE_ORE;

public class BlockTagProv extends BlockTagsProvider {
    public BlockTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OreConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(NETHER_COAL_ORE.get(), NETHER_COPPER_ORE.get(), NETHER_IRON_ORE.get(),
                        NETHER_DIAMOND_ORE.get(), NETHER_EMERALD_ORE.get(), NETHER_LAPIS_ORE.get(),
                        NETHER_REDSTONE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(NETHER_COAL_ORE.get(), NETHER_IRON_ORE.get(), NETHER_LAPIS_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(NETHER_REDSTONE_ORE.get(), NETHER_EMERALD_ORE.get(), NETHER_DIAMOND_ORE.get());

        this.tag(BlockTags.COAL_ORES).add(NETHER_COAL_ORE.get());
        this.tag(BlockTags.COPPER_ORES).add(NETHER_COPPER_ORE.get());
        this.tag(BlockTags.IRON_ORES).add(NETHER_IRON_ORE.get());
        this.tag(BlockTags.DIAMOND_ORES).add(NETHER_DIAMOND_ORE.get());
        this.tag(BlockTags.EMERALD_ORES).add(NETHER_EMERALD_ORE.get());
        this.tag(BlockTags.LAPIS_ORES).add(NETHER_LAPIS_ORE.get());
        this.tag(BlockTags.REDSTONE_ORES).add(NETHER_REDSTONE_ORE.get());
    }
}
