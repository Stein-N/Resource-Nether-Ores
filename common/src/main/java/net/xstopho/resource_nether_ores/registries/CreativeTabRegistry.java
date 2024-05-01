package net.xstopho.resource_nether_ores.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class CreativeTabRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.get(Registries.CREATIVE_MODE_TAB, OreConstants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_NETHER_ORES = CREATIVE_TABS.register("item-group",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, -1).title(Component.translatable("item_group.resource_nether_ores"))
                    .icon(() -> new ItemStack(BlockRegistry.NETHER_DIAMOND_ORE.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(BlockRegistry.NETHER_COAL_ORE.get());
                        output.accept(BlockRegistry.NETHER_COPPER_ORE.get());
                        output.accept(BlockRegistry.NETHER_IRON_ORE.get());
                        output.accept(BlockRegistry.NETHER_DIAMOND_ORE.get());
                        output.accept(BlockRegistry.NETHER_EMERALD_ORE.get());
                        output.accept(BlockRegistry.NETHER_LAPIS_ORE.get());
                        output.accept(BlockRegistry.NETHER_REDSTONE_ORE.get());

                    }).build());

    public static void init() {}
}
