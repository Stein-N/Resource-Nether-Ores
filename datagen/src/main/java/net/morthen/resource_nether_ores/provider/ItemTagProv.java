package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_nether_ores.OreConstants;
import net.morthen.resource_nether_ores.tags.OreTags;
import net.morthen.resourcelibrary.registration.RegistryObject;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.morthen.resource_nether_ores.registries.BlockRegistry.*;

public class ItemTagProv extends ItemTagsProvider {


    public ItemTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> unused) {
        super(output, lookupProvider, OreConstants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.addAll(OreTags.ORES,
                List.of(NETHER_COAL_ORE, NETHER_COPPER_ORE, NETHER_DIAMOND_ORE,
                        NETHER_EMERALD_ORE, NETHER_IRON_ORE, NETHER_LAPIS_ORE,
                        NETHER_REDSTONE_ORE));

        this.add(OreTags.COAL_ORE, NETHER_COAL_ORE);
        this.add(OreTags.COPPER_ORE, NETHER_COPPER_ORE);
        this.add(OreTags.IRON_ORE, NETHER_IRON_ORE);
        this.add(OreTags.DIAMOND_ORE, NETHER_DIAMOND_ORE);
        this.add(OreTags.EMERALD_ORE, NETHER_EMERALD_ORE);
        this.add(OreTags.LAPIS_ORE, NETHER_LAPIS_ORE);
        this.add(OreTags.REDSTONE_ORE, NETHER_REDSTONE_ORE);
    }

    private void add(TagKey<Item> key, RegistryObject<Block> block) {
        Identifier id = block.getId();
        this.tag(key).add(ResourceKey.create(Registries.ITEM, id));
    }

    private void addAll(TagKey<Item> key, List<RegistryObject<Block>> blocks) {
        blocks.forEach(block -> this.add(key, block));
    }
}
