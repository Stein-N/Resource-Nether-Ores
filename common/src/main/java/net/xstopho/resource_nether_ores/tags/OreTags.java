package net.xstopho.resource_nether_ores.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.util.TagHelper;

public class OreTags {

    public static final TagKey<Item> ORES = TagHelper.createItemTag("ores");
    public static final TagKey<Item> COAL_ORE = TagHelper.createItemTag("ore/coal");
    public static final TagKey<Item> COPPER_ORE = TagHelper.createItemTag("ore/copper");
    public static final TagKey<Item> IRON_ORE = TagHelper.createItemTag("ore/iron");
    public static final TagKey<Item> DIAMOND_ORE = TagHelper.createItemTag("ore/diamond");
    public static final TagKey<Item> EMERALD_ORE = TagHelper.createItemTag("ore/emerald");
    public static final TagKey<Item> LAPIS_ORE = TagHelper.createItemTag("ore/lapis");
    public static final TagKey<Item> REDSTONE_ORE = TagHelper.createItemTag("ore/redstone");
}
