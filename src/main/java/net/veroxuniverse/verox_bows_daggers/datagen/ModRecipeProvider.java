package net.veroxuniverse.verox_bows_daggers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModCurioItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModUpgradeItems;

import java.util.concurrent.CompletableFuture;

/** PLACEHOLDER recipes until the real progression is decided. */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RECURVE_BOW.get())
                .pattern(" SX").pattern("L X").pattern(" SX")
                .define('S', Items.STICK).define('X', Items.STRING).define('L', Items.LEATHER)
                .unlockedBy("has_string", has(Items.STRING)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LONGBOW.get())
                .pattern(" WX").pattern("S X").pattern(" WX")
                .define('W', ItemTags.LOGS).define('S', Items.STICK).define('X', Items.STRING)
                .unlockedBy("has_string", has(Items.STRING)).save(output);

        for (ModUpgradeItems.Entry upgrade : ModUpgradeItems.entries()) {
            ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, upgrade.item().get());
            for (ItemLike ingredient : upgrade.ingredients()) {
                builder.requires(ingredient);
            }
            ItemLike first = upgrade.ingredients().get(0);
            builder.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(first.asItem()).getPath(), has(first)).save(output);
        }
        for (ModCurioItems.Entry curio : ModCurioItems.entries()) {
            ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, curio.item().get());
            for (ItemLike ingredient : curio.ingredients()) {
                builder.requires(ingredient);
            }
            ItemLike first = curio.ingredients().get(0);
            builder.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(first.asItem()).getPath(), has(first)).save(output);
        }
    }
}
