package net.veroxuniverse.verox_bows_daggers.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;
import net.veroxuniverse.verox_bows_daggers.item.ArcherBowItem;

import java.util.List;

public final class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BowsNDaggers.MOD_ID);

    public static final DeferredItem<ArcherBowItem> RECURVE_BOW = ITEMS.register("recurve_bow",
            () -> new ArcherBowItem(new Item.Properties().durability(384)));
    public static final DeferredItem<ArcherBowItem> LONGBOW = ITEMS.register("longbow",
            () -> new ArcherBowItem(new Item.Properties().durability(450)));

    private ModItems() {}

    public static List<DeferredItem<ArcherBowItem>> bows() {
        return List.of(RECURVE_BOW, LONGBOW);
    }
}
