package net.xstopho.resource_nether_ores.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class ModelProv extends BlockStateProvider {
    public ModelProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OreConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createTrivialCube(BlockRegistry.NETHER_COAL_ORE);
        createTrivialCube(BlockRegistry.NETHER_COPPER_ORE);
        createTrivialCube(BlockRegistry.NETHER_IRON_ORE);
        createTrivialCube(BlockRegistry.NETHER_DIAMOND_ORE);
        createTrivialCube(BlockRegistry.NETHER_EMERALD_ORE);
        createTrivialCube(BlockRegistry.NETHER_LAPIS_ORE);
        createTrivialCube(BlockRegistry.NETHER_REDSTONE_ORE);
    }

    void createTrivialCube(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
