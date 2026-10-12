package net.veroxuniverse.verox_bows_daggers.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModCurioItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModUpgradeItems;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, BowsNDaggers.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + BowsNDaggers.MOD_ID, "Verox' Bows n' Daggers");

        addItem(ModItems.RECURVE_BOW, "Recurve Bow");
        addItem(ModItems.LONGBOW, "Longbow");
        addItem(ModItems.DAGGER, "Dagger");
        addItem(ModItems.TWIN_GLAIVE, "Twin Glaive");

        for (ModUpgradeItems.Entry upgrade : ModUpgradeItems.entries()) {
            addItem(upgrade.item(), upgrade.name());
        }
        for (ModCurioItems.Entry curio : ModCurioItems.entries()) {
            addItem(curio.item(), curio.name());
        }
    }
}
