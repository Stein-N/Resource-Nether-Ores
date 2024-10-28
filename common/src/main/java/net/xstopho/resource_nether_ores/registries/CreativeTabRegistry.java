package net.xstopho.resource_nether_ores.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class CreativeTabRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.get(OreConstants.MOD_ID, BuiltInRegistries.CREATIVE_MODE_TAB);

    public static final RegistryObject<CreativeModeTab> RESOURCE_NETHER_ORES = CREATIVE_TABS.register("item-group",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, -1).title(Component.translatable("item_group.resource_nether_ores"))
                    .icon(() -> new ItemStack(BlockRegistry.NETHER_DIAMOND_ORE.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        BlockRegistry.BLOCKS.getEntries().forEach(registryObject -> {
                            output.accept(registryObject.get());
                        });

                    }).build());

    public static void init() {}
}
