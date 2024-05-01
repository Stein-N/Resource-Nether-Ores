package net.xstopho.resource_nether_ores.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.items.tags.TagHelper;

public class OreTags {

    public static final TagKey<Item> ORES = TagHelper.createPlatformTag("ores", "ores");
    public static final TagKey<Item> COAL_ORE = TagHelper.createPlatformTag("coal_ore", "ore/coal");
    public static final TagKey<Item> COPPER_ORE = TagHelper.createPlatformTag("copper_ore", "ore/copper");
    public static final TagKey<Item> IRON_ORE = TagHelper.createPlatformTag("iron_ore", "ore/iron");
    public static final TagKey<Item> DIAMOND_ORE = TagHelper.createPlatformTag("diamond_ore", "ore/diamond");
    public static final TagKey<Item> EMERALD_ORE = TagHelper.createPlatformTag("emerald_ore", "ore/emerald");
    public static final TagKey<Item> LAPIS_ORE = TagHelper.createPlatformTag("lapis_ore", "ore/lapis");
    public static final TagKey<Item> REDSTONE_ORE = TagHelper.createPlatformTag("redstone_ore", "ore/redstone");
}
