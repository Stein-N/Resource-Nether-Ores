package net.xstopho.resource_nether_ores.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(OreConstants.MOD_ID, BuiltInRegistries.BLOCK);
    private static final RegistryProvider<Item> ITEMS = RegistryProvider.get(OreConstants.MOD_ID, BuiltInRegistries.ITEM);


    public static final RegistryObject<Block> NETHER_COAL_ORE = register("nether_coal_ore",
            properties -> new DropExperienceBlock(ConstantInt.of(0), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE));

    public static final RegistryObject<Block> NETHER_COPPER_ORE = register("nether_copper_ore",
            properties -> new DropExperienceBlock(ConstantInt.of(0), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE));

    public static final RegistryObject<Block> NETHER_IRON_ORE = register("nether_iron_ore",
            properties -> new DropExperienceBlock(ConstantInt.of(0), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE));

    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = register("nether_diamond_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 7), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE));

    public static final RegistryObject<Block> NETHER_EMERALD_ORE = register("nether_emerald_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 7), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE));

    public static final RegistryObject<Block> NETHER_LAPIS_ORE = register("nether_lapis_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 5), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_ORE));

    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = register("nether_redstone_ore",
            RedStoneOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_ORE));




    private static RegistryObject<Block> register(String id, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockBehavior) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, () -> function.apply(blockBehavior.setId(createBlockKey(id))));
        register(id, properties -> new BlockItem(toReturn.get(), properties));

        return toReturn;
    }

    private static void register(String id, Function<Item.Properties, Item> function) {
        ITEMS.register(id, () -> function.apply(new Item.Properties().setId(createItemKey(id))));
    }

    private static ResourceKey<Block> createBlockKey(String id) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, id));
    }

    private static ResourceKey<Item> createItemKey(String id) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, id));
    }

    public static void init() {}
}
