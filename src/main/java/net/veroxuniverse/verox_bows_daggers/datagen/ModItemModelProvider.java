package net.veroxuniverse.verox_bows_daggers.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModCurioItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModUpgradeItems;

/**
 * PLACEHOLDERS: the bows use the vanilla bow textures for now, including the three pulling stages.
 * Once the real models exist, swap the textures here (or switch to GeckoLib for the 3D weapon models).
 */
public class ModItemModelProvider extends ItemModelProvider {

    private static final float[] PULL_STAGES = {0.0F, 0.65F, 0.9F};

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BowsNDaggers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        bowPlaceholder(ModItems.RECURVE_BOW);
        bowPlaceholder(ModItems.LONGBOW);
        handheldPlaceholder(ModItems.DAGGER, "item/stone_sword");
        handheldPlaceholder(ModItems.TWIN_GLAIVE, "item/netherite_sword");

        for (ModUpgradeItems.Entry upgrade : ModUpgradeItems.entries()) {
            withExistingParent(upgrade.item().getId().getPath(), mcLoc("item/generated"))
                    .texture("layer0", mcLoc(upgrade.placeholderTexture()));
        }
        for (ModCurioItems.Entry curio : ModCurioItems.entries()) {
            withExistingParent(curio.item().getId().getPath(), mcLoc("item/generated"))
                    .texture("layer0", mcLoc(curio.placeholderTexture()));
        }
    }

    private void bowPlaceholder(DeferredItem<? extends Item> item) {
        String name = item.getId().getPath();
        ItemModelBuilder bow = withExistingParent(name, mcLoc("item/bow")).texture("layer0", mcLoc("item/bow"));

        for (int stage = 0; stage < PULL_STAGES.length; stage++) {
            ModelFile pulling = withExistingParent(name + "_pulling_" + stage, mcLoc("item/bow"))
                    .texture("layer0", mcLoc("item/bow_pulling_" + stage));
            bow.override()
                    .predicate(mcLoc("pulling"), 1.0F)
                    .predicate(mcLoc("pull"), PULL_STAGES[stage])
                    .model(pulling)
                    .end();
        }
    }

    private void handheldPlaceholder(DeferredItem<? extends Item> item, String vanillaTexture) {
        withExistingParent(item.getId().getPath(), mcLoc("item/handheld")).texture("layer0", mcLoc(vanillaTexture));
    }
}
