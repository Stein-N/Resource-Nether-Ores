package net.morthen.template;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CommonConstants.MOD_ID)
public class TemplateMod {
    public TemplateMod(IEventBus eventBus) {
        CommonConstants.commonInit();
        CommonConstants.LOGGER.info("TemplateMod Loaded");
    }
}
