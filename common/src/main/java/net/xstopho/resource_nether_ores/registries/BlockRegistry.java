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
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> NETHER_COPPER_ORE = register("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE), ConstantInt.of(0)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = register("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE), ConstantInt.of(0)));
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = register("nether_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(1, 7)));
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = register("nether_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE), UniformInt.of(1, 7)));
    public static final RegistryObject<Block> NETHER_LAPIS_ORE = register("nether_lapis_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE), UniformInt.of(1, 5)));
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = register("nether_redstone_ore",
            () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));

    private static RegistryObject<Block> register(String id, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, block);
        ITEMS.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void init() {}
}
