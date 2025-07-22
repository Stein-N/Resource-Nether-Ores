package net.xstopho.resource_nether_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.Optional;

public class ModelProv extends FabricModelProvider {
    public ModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators block) {
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_COAL_ORE, "coal_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_COPPER_ORE, "copper_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_IRON_ORE, "iron_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_DIAMOND_ORE, "diamond_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_EMERALD_ORE, "emerald_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_LAPIS_ORE, "lapis_ore");
        createLayeredNetherOreBlock(block, BlockRegistry.NETHER_REDSTONE_ORE, "redstone_ore");
    }

    @Override
    public void generateItemModels(ItemModelGenerators item) {

    }

    private void createLayeredNetherOreBlock(BlockModelGenerators generator, RegistryObject<Block> block, String textureKey) {
        TextureMapping map = new TextureMapping();
        Optional<ResourceLocation> parent = Optional.of(ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, "block/simple_cube"));

        map.put(TextureSlot.ALL, ResourceLocation.withDefaultNamespace("block/netherrack"));
        map.put(TextureSlot.LAYER0, ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, "block/" + textureKey));

        ResourceLocation model = new ModelTemplate(parent, Optional.empty(), TextureSlot.ALL, TextureSlot.LAYER0)
                .create(ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, "block/nether_" + textureKey), map, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block.get(), model));
    }
}
