package net.xstopho.resource_nether_ores.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.util.TagUtil;

public class OreTags {

    public static final TagKey<Item> ORES = TagUtil.createItemTag("ores");
    public static final TagKey<Item> COAL_ORE = TagUtil.createItemTag("ore/coal");
    public static final TagKey<Item> COPPER_ORE = TagUtil.createItemTag("ore/copper");
    public static final TagKey<Item> IRON_ORE = TagUtil.createItemTag("ore/iron");
    public static final TagKey<Item> DIAMOND_ORE = TagUtil.createItemTag("ore/diamond");
    public static final TagKey<Item> EMERALD_ORE = TagUtil.createItemTag("ore/emerald");
    public static final TagKey<Item> LAPIS_ORE = TagUtil.createItemTag("ore/lapis");
    public static final TagKey<Item> REDSTONE_ORE = TagUtil.createItemTag("ore/redstone");
}
