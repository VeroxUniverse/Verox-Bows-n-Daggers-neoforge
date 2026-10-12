package net.veroxuniverse.verox_bows_daggers.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import net.veroxuniverse.unbound_lib.curio.StatCurioItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModCurioItems {

    public record Entry(DeferredItem<StatCurioItem> item, String name, String slot, String placeholderTexture, List<ItemLike> ingredients) {}

    private static final List<Entry> ENTRIES = new ArrayList<>();

    public static final DeferredItem<StatCurioItem> MARKSMANS_ARMGUARD = curio("marksmans_armguard", "Marksman's Armguard", "hands", "item/leather",
            Items.LEATHER, Items.STRING, Items.TARGET);
    public static final DeferredItem<StatCurioItem> QUIVER_BADGE = curio("quiver_badge", "Quiver Badge", "belt", "item/arrow",
            Items.GOLD_NUGGET, Items.ARROW, Items.LEATHER);
    public static final DeferredItem<StatCurioItem> PRECISION_MONOCLE = curio("precision_monocle", "Precision Monocle", "head", "item/spyglass",
            Items.GLASS_PANE, Items.GOLD_NUGGET, Items.COPPER_INGOT);
    public static final DeferredItem<StatCurioItem> SHADOWVEIL_TALISMAN = curio("shadowveil_talisman", "Shadowveil Talisman", "necklace", "item/ender_eye",
            Items.OBSIDIAN, Items.STRING, Items.FERMENTED_SPIDER_EYE);
    public static final DeferredItem<StatCurioItem> BAND_OF_SILENT_STEPS = curio("band_of_silent_steps", "Band of Silent Steps", "ring", "item/iron_nugget",
            Items.IRON_INGOT, Items.BLACK_WOOL, Items.PHANTOM_MEMBRANE);
    public static final DeferredItem<StatCurioItem> STRANGLERS_NOOSE = curio("stranglers_noose", "Strangler's Noose", "necklace", "item/lead",
            Items.LEAD, Items.RED_DYE, Items.IRON_NUGGET);

    private ModCurioItems() {}

    /** Loads the class so the items are added to {@link ModItems#ITEMS} before registration. */
    public static void init() {}

    public static List<Entry> entries() {
        return Collections.unmodifiableList(ENTRIES);
    }

    private static DeferredItem<StatCurioItem> curio(String id, String name, String slot, String placeholderTexture, ItemLike... ingredients) {
        DeferredItem<StatCurioItem> item = ModItems.ITEMS.register(id,
                () -> new StatCurioItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
        ENTRIES.add(new Entry(item, name, slot, placeholderTexture, List.of(ingredients)));
        return item;
    }
}
