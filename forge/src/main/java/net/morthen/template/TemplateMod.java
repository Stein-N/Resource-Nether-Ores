package net.morthen.template;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CommonConstants.MOD_ID)
public class TemplateMod {
    public TemplateMod(FMLJavaModLoadingContext context) {
        CommonConstants.commonInit();
        CommonConstants.LOGGER.info("Loading TemplateMod");
    }
}
