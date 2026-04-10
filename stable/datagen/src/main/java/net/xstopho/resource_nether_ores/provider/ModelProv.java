package net.xstopho.resource_nether_ores.provider;


import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ModelProv extends ModelProvider {
    public ModelProv(PackOutput packOutput) {
        super(packOutput, OreConstants.MOD_ID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        createOreModel(BlockRegistry.NETHER_COAL_ORE, "coal_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_COPPER_ORE, "copper_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_IRON_ORE, "iron_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_DIAMOND_ORE, "diamond_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_EMERALD_ORE, "emerald_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_REDSTONE_ORE, "redstone_ore", blockModels);
        createOreModel(BlockRegistry.NETHER_LAPIS_ORE, "lapis_ore", blockModels);
    }

    private void createOreModel(RegistryObject<Block> block, String texture, BlockModelGenerators blockModels) {
        TextureMapping textureMap = new TextureMapping();
        textureMap.put(TextureSlot.ALL, new Material(Identifier.withDefaultNamespace("block/netherrack")));
        textureMap.put(TextureSlot.LAYER0, new Material(Identifier.fromNamespaceAndPath(OreConstants.MOD_ID, "block/" + texture)));

        ModelTemplate template = new ModelTemplate(
                Optional.of(Identifier.fromNamespaceAndPath(OreConstants.MOD_ID, "block/simple_cube")),
                Optional.empty(), TextureSlot.ALL, TextureSlot.LAYER0);

        Identifier location = template.create(block.get(), textureMap, blockModels.modelOutput);

        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block.get(), BlockModelGenerators.plainVariant(location)));

        new ModelTemplate(Optional.of(location), Optional.empty()).create(block.get().asItem(), new TextureMapping(), blockModels.modelOutput);
    }
}
