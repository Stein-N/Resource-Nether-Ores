package net.xstopho.resource_ores.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.tags.OreTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.xstopho.resource_nether_ores.registries.BlockRegistry.*;

public class ItemTagProv extends ItemTagsProvider {


    public ItemTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> lookup,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, lookup, OreConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(OreTags.ORES)
                .add(NETHER_COAL_ORE.get().asItem(), NETHER_COPPER_ORE.get().asItem(), NETHER_IRON_ORE.get().asItem(),
                        NETHER_DIAMOND_ORE.get().asItem(), NETHER_EMERALD_ORE.get().asItem(), NETHER_LAPIS_ORE.get().asItem(),
                        NETHER_REDSTONE_ORE.get().asItem());

        this.tag(OreTags.COAL_ORE).add(NETHER_COAL_ORE.get().asItem());
        this.tag(OreTags.COPPER_ORE).add(NETHER_COPPER_ORE.get().asItem());
        this.tag(OreTags.IRON_ORE).add(NETHER_IRON_ORE.get().asItem());
        this.tag(OreTags.DIAMOND_ORE).add(NETHER_DIAMOND_ORE.get().asItem());
        this.tag(OreTags.EMERALD_ORE).add(NETHER_EMERALD_ORE.get().asItem());
        this.tag(OreTags.LAPIS_ORE).add(NETHER_LAPIS_ORE.get().asItem());
        this.tag(OreTags.REDSTONE_ORE).add(NETHER_REDSTONE_ORE.get().asItem());
    }
}
