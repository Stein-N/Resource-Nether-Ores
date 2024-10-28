package net.xstopho.resource_nether_ores;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.*;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModInfo;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;
import org.apache.maven.artifact.versioning.ArtifactVersion;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Function;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres() {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ResourceNetherOresClient {

        @SubscribeEvent
        public static void renderSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_COAL_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_COPPER_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_IRON_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_DIAMOND_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_EMERALD_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_LAPIS_ORE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.NETHER_REDSTONE_ORE.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void registerResourcePacks(AddPackFindersEvent event) {
            addPackFinders(event, location("resource_nether_ores_x32"), PackType.CLIENT_RESOURCES, Component.literal("Resource Nether Ores x32"), PackSource.BUILT_IN, false, Pack.Position.TOP);
            addPackFinders(event, location("resource_nether_ores_x64"), PackType.CLIENT_RESOURCES, Component.literal("Resource Nether Ores x64"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        }

        private static void addPackFinders(AddPackFindersEvent event, ResourceLocation packLocation, PackType packType, Component packNameDisplay, PackSource packSource, boolean alwaysActive, Pack.Position packPosition) {
            if (event.getPackType() == packType) {
                IModInfo modInfo = (ModList.get().getModContainerById(packLocation.getNamespace()).orElseThrow(() -> new IllegalArgumentException("Mod not found: " + packLocation.getNamespace()))).getModInfo();
                Path resourcePath = modInfo.getOwningFile().getFile().findResource(packLocation.getPath());
                ArtifactVersion version = modInfo.getVersion();
                Pack pack = Pack.readMetaAndCreate(new PackLocationInfo("mod/" + packLocation, packNameDisplay, packSource, Optional.of(new KnownPack("neoforge", "mod/" + packLocation, version.toString()))),
                        fromName((path) -> new PathPackResources(path, resourcePath)), packType, new PackSelectionConfig(alwaysActive, packPosition, false));
                event.addRepositorySource((packConsumer) -> {
                    packConsumer.accept(pack);
                });
            }
        }

        public static Pack.ResourcesSupplier fromName(final Function<PackLocationInfo, PackResources> onName) {
            return new Pack.ResourcesSupplier() {
                public PackResources openPrimary(PackLocationInfo p_294636_) {
                    return onName.apply(p_294636_);
                }

                public PackResources openFull(PackLocationInfo p_251717_, Pack.Metadata p_294956_) {
                    return onName.apply(p_251717_);
                }
            };
        }

        private static ResourceLocation location(String id) {
            return ResourceLocation.fromNamespaceAndPath(OreConstants.MOD_ID, "resourcepacks/" + id);
        }
    }
}
