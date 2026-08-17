package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_nether_ores.OreConstants;
import net.morthen.resourcelibrary.registration.RegistryObject;
import net.neoforged.neoforge.common.Tags;
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
        this.addAll(Tags.Items.ORES,
                List.of(NETHER_COAL_ORE, NETHER_COPPER_ORE, NETHER_DIAMOND_ORE,
                        NETHER_EMERALD_ORE, NETHER_IRON_ORE, NETHER_LAPIS_ORE,
                        NETHER_REDSTONE_ORE));

        this.add(Tags.Items.ORES_COAL, NETHER_COAL_ORE);
        this.add(Tags.Items.ORES_COPPER, NETHER_COPPER_ORE);
        this.add(Tags.Items.ORES_IRON, NETHER_IRON_ORE);
        this.add(Tags.Items.ORES_DIAMOND, NETHER_DIAMOND_ORE);
        this.add(Tags.Items.ORES_EMERALD, NETHER_EMERALD_ORE);
        this.add(Tags.Items.ORES_LAPIS, NETHER_LAPIS_ORE);
        this.add(Tags.Items.ORES_REDSTONE, NETHER_REDSTONE_ORE);
    }

    private void add(TagKey<Item> key, RegistryObject<Block> block) {
        this.tag(key).add(block.get().asItem());
    }

    private void addAll(TagKey<Item> key, List<RegistryObject<Block>> blocks) {
        blocks.forEach(block -> this.add(key, block));
    }
}
