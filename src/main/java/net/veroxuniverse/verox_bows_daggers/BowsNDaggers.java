package net.veroxuniverse.verox_bows_daggers;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.veroxuniverse.verox_bows_daggers.registry.ModArmorMaterials;
import net.veroxuniverse.verox_bows_daggers.registry.ModBlocks;
import net.veroxuniverse.verox_bows_daggers.registry.ModCreativeTabs;
import net.veroxuniverse.verox_bows_daggers.registry.ModCurioItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModItems;
import net.veroxuniverse.verox_bows_daggers.registry.ModUpgradeItems;
import org.slf4j.Logger;

@Mod(BowsNDaggers.MOD_ID)
public class BowsNDaggers {
    public static final String MOD_ID = "verox_bows_daggers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BowsNDaggers(IEventBus modEventBus, ModContainer modContainer) {
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModUpgradeItems.init();
        ModCurioItems.init();
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
    }

    public static ResourceLocation id(String path) {

        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
