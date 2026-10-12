package net.veroxuniverse.verox_bows_daggers.client;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;
import net.veroxuniverse.verox_bows_daggers.item.ArcherBowItem;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;

/** The "pull" / "pulling" predicates of the vanilla bow, for the item model overrides of our bows. */
@EventBusSubscriber(modid = BowsNDaggers.MOD_ID, value = Dist.CLIENT)
public final class ModItemProperties {

    private static final ResourceLocation PULL = ResourceLocation.withDefaultNamespace("pull");
    private static final ResourceLocation PULLING = ResourceLocation.withDefaultNamespace("pulling");
    private static final float FULL_DRAW_TICKS = 20.0F;

    private ModItemProperties() {}

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            for (DeferredItem<ArcherBowItem> bow : ModItems.bows()) {
                ItemProperties.register(bow.get(), PULL, (stack, level, entity, seed) -> {
                    if (entity == null || entity.getUseItem() != stack) return 0.0F;
                    return (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / FULL_DRAW_TICKS;
                });
                ItemProperties.register(bow.get(), PULLING, (stack, level, entity, seed) ->
                        entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
            }
        });
    }
}
