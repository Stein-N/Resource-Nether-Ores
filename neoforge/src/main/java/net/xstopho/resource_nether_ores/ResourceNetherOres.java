package net.xstopho.resource_nether_ores;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {
    
    public ResourceNetherOres(IEventBus bus) {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }
}
