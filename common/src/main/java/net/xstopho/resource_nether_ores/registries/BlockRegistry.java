package net.xstopho.resource_nether_ores.registries;

import net.minecraft.core.registries.Registries;
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

import java.util.function.Supplier;

public class BlockRegistry {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(Registries.BLOCK, OreConstants.MOD_ID);
    private static final RegistryProvider<Item> ITEMS = RegistryProvider.get(Registries.ITEM, OreConstants.MOD_ID);

    public static final RegistryObject<Block> NETHER_COAL_ORE = register("nether_coal_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));
    public static final RegistryObject<Block> NETHER_COPPER_ORE = register("nether_copper_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = register("nether_iron_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = register("nether_diamond_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = register("nether_emerald_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> NETHER_LAPIS_ORE = register("nether_lapis_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = register("nether_redstone_ore",
            () -> new RedStoneOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_ORE)));

    private static RegistryObject<Block> register(String id, Supplier<Block> block) {
        ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return BLOCKS.register(id, block);
    }

    public static void init() {}
}
