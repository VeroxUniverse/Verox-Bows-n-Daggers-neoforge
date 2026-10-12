package net.veroxuniverse.verox_bows_daggers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider.TagLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.veroxuniverse.unbound_lib.tag.LibItemTags;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;
import net.veroxuniverse.verox_bows_daggers.item.ArcherBowItem;
import net.veroxuniverse.verox_bows_daggers.registry.ModCurioItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BowsNDaggers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (ModCurioItems.Entry curio : ModCurioItems.entries()) {
            tag(curioSlot(curio.slot())).add(curio.item().get());
        }

        for (DeferredItem<SwordItem> blade : ModItems.blades()) {
            tag(ItemTags.SWORDS).add(blade.get());
            tag(LibItemTags.MELEE_WEAPONS).add(blade.get());
            tag(LibItemTags.ASSASSIN_WEAPONS).add(blade.get());
        }

        for (DeferredItem<ArcherBowItem> bow : ModItems.bows()) {
            tag(ItemTags.BOW_ENCHANTABLE).add(bow.get());
            tag(ItemTags.DURABILITY_ENCHANTABLE).add(bow.get());
            tag(ItemTags.VANISHING_ENCHANTABLE).add(bow.get());
            tag(Tags.Items.TOOLS_BOW).add(bow.get());
            tag(LibItemTags.MARKSMAN_WEAPONS).add(bow.get());
        }
    }

    private static TagKey<Item> curioSlot(String slot) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", slot));
    }
}
