package net.veroxuniverse.verox_bows_daggers.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.verox_bows_daggers.BowsNDaggers;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, BowsNDaggers.MOD_ID);

    private ModArmorMaterials() {}

    static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String name, int boots, int chest, int legs, int helmet, int enchantability, Holder<SoundEvent> sound, float toughness, float knockbackResistance, ItemLike repair) {

        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, boots);
                    map.put(ArmorItem.Type.LEGGINGS, legs);
                    map.put(ArmorItem.Type.CHESTPLATE, chest);
                    map.put(ArmorItem.Type.HELMET, helmet);
                    map.put(ArmorItem.Type.BODY, chest);
                }),
                enchantability,
                sound,
                () -> Ingredient.of(repair),
                List.of(new ArmorMaterial.Layer(BowsNDaggers.id(name))),
                toughness,
                knockbackResistance));
    }
}
