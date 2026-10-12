package net.veroxuniverse.verox_bows_daggers.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class ArcherBowItem extends BowItem {

    public ArcherBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return !enchantment.is(Enchantments.INFINITY) && super.supportsEnchantment(stack, enchantment);
    }

    @Override
    public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
        return !enchantment.is(Enchantments.INFINITY) && super.isPrimaryItemFor(stack, enchantment);
    }
}
