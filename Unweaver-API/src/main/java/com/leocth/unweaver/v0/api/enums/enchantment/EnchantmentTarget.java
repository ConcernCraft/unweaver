package com.leocth.unweaver.v0.api.enums.enchantment;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.enchantment.EnchantmentTargetImpl;
import net.minecraft.item.Item;

import java.util.function.Predicate;

public interface EnchantmentTarget extends ExtendedEnum<net.minecraft.enchantment.EnchantmentTarget> {

    VanillaFactory<net.minecraft.enchantment.EnchantmentTarget, EnchantmentTarget> VANILLA
            = new CachedVanillaFactory<>(EnchantmentTargetImpl::new);

    boolean isAcceptableItem(Item item);

    static EnchantmentTarget create(Predicate<Item> isAcceptablePredicate) {
        return new EnchantmentTargetImpl(isAcceptablePredicate);
    }
}
