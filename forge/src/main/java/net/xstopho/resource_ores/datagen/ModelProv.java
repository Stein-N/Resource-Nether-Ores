package net.xstopho.resource_ores.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class ModelProv extends BlockStateProvider {
    public ModelProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OreConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createTrivialCube(BlockRegistry.NETHER_COAL_ORE, "coal_ore");
        createTrivialCube(BlockRegistry.NETHER_COPPER_ORE, "copper_ore");
        createTrivialCube(BlockRegistry.NETHER_IRON_ORE, "iron_ore");
        createTrivialCube(BlockRegistry.NETHER_DIAMOND_ORE, "diamond_ore");
        createTrivialCube(BlockRegistry.NETHER_EMERALD_ORE, "emerald_ore");
        createTrivialCube(BlockRegistry.NETHER_LAPIS_ORE, "lapis_ore");
        createTrivialCube(BlockRegistry.NETHER_REDSTONE_ORE, "redstone_ore");
    }

    void createTrivialCube(RegistryObject<Block> block, String textureKey) {
        simpleBlockWithItem(block.get(), createLayeredNetherOreBlock(textureKey).model);
    }

    private ConfiguredModel createLayeredNetherOreBlock(String textureKey) {
        return new ConfiguredModel(models().withExistingParent("nether_" + textureKey, location("block/simple_cube"))
                .texture("all", ResourceLocation.withDefaultNamespace("block/netherrack"))
                .texture("layer0", location("block/" + textureKey)));
    }

    private ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, path);
    }
}
