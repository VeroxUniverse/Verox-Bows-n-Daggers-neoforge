package net.veroxuniverse.verox_bows_daggers.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModUpgradeItems {

    public record Entry(DeferredItem<Item> item, String name, String placeholderTexture, List<ItemLike> ingredients) {}

    private static final List<Entry> ENTRIES = new ArrayList<>();

    public static final DeferredItem<Item> STRING_TENSIONER = upgrade("string_tensioner", "String Tensioner", "item/string", Rarity.COMMON,
            Items.STRING, Items.RABBIT_HIDE, Items.IRON_INGOT);
    public static final DeferredItem<Item> AERODYNAMIC_FLETCHING = upgrade("aerodynamic_fletching", "Aerodynamic Fletching", "item/feather", Rarity.COMMON,
            Items.FEATHER, Items.PHANTOM_MEMBRANE, Items.EMERALD);
    public static final DeferredItem<Item> FOCUS_LENS = upgrade("focus_lens", "Focus Lens", "item/amethyst_shard", Rarity.UNCOMMON,
            Items.GLASS_PANE, Items.AMETHYST_SHARD, Items.COPPER_INGOT);
    public static final DeferredItem<Item> COPPER_THORN_TIP = upgrade("copper_thorn_tip", "Copper Thorn Tip", "item/copper_ingot", Rarity.COMMON,
            Items.COPPER_INGOT, Items.FLINT, Items.ARROW);
    public static final DeferredItem<Item> QUIVER_STRAP = upgrade("quiver_strap", "Quiver Strap", "item/leather", Rarity.COMMON,
            Items.LEATHER, Items.STRING, Items.HONEYCOMB);
    public static final DeferredItem<Item> RUNNERS_GAITERS = upgrade("runners_gaiters", "Runner's Gaiters", "item/rabbit_hide", Rarity.COMMON,
            Items.LEATHER, Items.RABBIT_HIDE, Items.STRING);
    public static final DeferredItem<Item> HEAVY_BALLISTA_STRING = upgrade("heavy_ballista_string", "Heavy Ballista String", "item/string", Rarity.COMMON,
            Items.STRING, Items.IRON_BLOCK, Items.LEATHER);
    public static final DeferredItem<Item> FALCON_EYE_SIGHT = upgrade("falcon_eye_sight", "Falcon-Eye Sight", "item/spyglass", Rarity.COMMON,
            Items.SPYGLASS, Items.COPPER_INGOT);

    public static final DeferredItem<Item> SHADOWBLADE_HONE = upgrade("shadowblade_hone", "Shadowblade Hone", "item/flint", Rarity.COMMON,
            Items.OBSIDIAN, Items.FLINT);
    public static final DeferredItem<Item> BLOODLETTING_GROOVE = upgrade("bloodletting_groove", "Bloodletting Groove", "item/ghast_tear", Rarity.COMMON,
            Items.IRON_INGOT, Items.GHAST_TEAR);
    public static final DeferredItem<Item> NIGHTSHADE_COATING = upgrade("nightshade_coating", "Nightshade Coating", "item/fermented_spider_eye", Rarity.UNCOMMON,
            Items.FERMENTED_SPIDER_EYE, Items.GUNPOWDER);
    public static final DeferredItem<Item> POISON_RESERVOIR = upgrade("poison_reservoir", "Poison Reservoir", "item/spider_eye", Rarity.UNCOMMON,
            Items.GLASS_BOTTLE, Items.SPIDER_EYE, Items.SLIME_BALL);
    public static final DeferredItem<Item> SILENT_TREAD = upgrade("silent_tread", "Silent Tread", "item/echo_shard", Rarity.COMMON,
            Items.WHITE_WOOL, Items.LEATHER, Items.ECHO_SHARD);
    public static final DeferredItem<Item> GLASS_DAGGER_HONE = upgrade("glass_dagger_hone", "Glass Dagger Hone", "item/amethyst_shard", Rarity.COMMON,
            Items.AMETHYST_SHARD, Items.GLASS_PANE, Items.OBSIDIAN);
    public static final DeferredItem<Item> SHADOWRUNNER_LINING = upgrade("shadowrunner_lining", "Shadowrunner Lining", "item/phantom_membrane", Rarity.COMMON,
            Items.BLACK_WOOL, Items.PHANTOM_MEMBRANE, Items.IRON_INGOT);

    private ModUpgradeItems() {}

    /** Loads the class so the items are added to {@link ModItems#ITEMS} before registration. */
    public static void init() {}

    public static List<Entry> entries() {
        return Collections.unmodifiableList(ENTRIES);
    }

    private static DeferredItem<Item> upgrade(String id, String name, String placeholderTexture, Rarity rarity, ItemLike... ingredients) {
        DeferredItem<Item> item = ModItems.ITEMS.registerSimpleItem(id, new Item.Properties().rarity(rarity));
        ENTRIES.add(new Entry(item, name, placeholderTexture, List.of(ingredients)));
        return item;
    }
}