package net.xstopho.resource_nether_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;

public class ModelProv extends FabricModelProvider {
    public ModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators block) {
        block.createTrivialCube(BlockRegistry.NETHER_COAL_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_COPPER_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_IRON_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_DIAMOND_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_EMERALD_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_LAPIS_ORE.get());
        block.createTrivialCube(BlockRegistry.NETHER_REDSTONE_ORE.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators item) {

    }
}
