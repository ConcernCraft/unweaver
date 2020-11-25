package com.leocth.unweaver.v0.impl.enums.enchantment;

import com.leocth.unweaver.v0.api.enums.enchantment.EnchantmentTarget;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import net.minecraft.item.Item;

import java.util.function.Predicate;

public class EnchantmentTargetImpl extends AbstractExtendedEnum<net.minecraft.enchantment.EnchantmentTarget> implements EnchantmentTarget {

    private final Predicate<Item> isAcceptablePredicate;

    public EnchantmentTargetImpl(Predicate<Item> isAcceptablePredicate) {
        super(null);
        this.isAcceptablePredicate = isAcceptablePredicate;
    }

    public EnchantmentTargetImpl(net.minecraft.enchantment.EnchantmentTarget vanilla) {
        super(vanilla);
        this.isAcceptablePredicate = vanilla::isAcceptableItem;
    }

    @Override
    public boolean isAcceptableItem(Item item) {
        return isAcceptablePredicate.test(item);
    }
}
