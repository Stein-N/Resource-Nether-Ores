package net.morthen.resource_nether_ores.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class OreTags {
    public static final TagKey<Item> ORES = create("ores");
    public static final TagKey<Item> COAL_ORE = create("ore/coal");
    public static final TagKey<Item> COPPER_ORE = create("ore/copper");
    public static final TagKey<Item> IRON_ORE = create("ore/iron");
    public static final TagKey<Item> DIAMOND_ORE = create("ore/diamond");
    public static final TagKey<Item> EMERALD_ORE = create("ore/emerald");
    public static final TagKey<Item> LAPIS_ORE = create("ore/lapis");
    public static final TagKey<Item> REDSTONE_ORE = create("ore/redstone");

    private static TagKey<Item> create(String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
    }
}
