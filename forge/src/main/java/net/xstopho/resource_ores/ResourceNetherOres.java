package net.xstopho.resource_ores;

import net.minecraftforge.fml.common.Mod;
import net.xstopho.resource_nether_ores.OreConstants;
import net.xstopho.resource_nether_ores.registries.BlockRegistry;
import net.xstopho.resource_nether_ores.registries.CreativeTabRegistry;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres() {
        BlockRegistry.init();
        CreativeTabRegistry.init();
    }
}
