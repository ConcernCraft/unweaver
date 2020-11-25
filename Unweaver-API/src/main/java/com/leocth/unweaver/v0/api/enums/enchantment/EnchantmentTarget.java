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

    EnchantmentTarget ARMOR         = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.ARMOR);
    EnchantmentTarget ARMOR_FEET    = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.ARMOR_FEET);
    EnchantmentTarget ARMOR_LEGS    = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.ARMOR_LEGS);
    EnchantmentTarget ARMOR_CHEST   = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.ARMOR_CHEST);
    EnchantmentTarget ARMOR_HEAD    = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.ARMOR_HEAD);
    EnchantmentTarget WEAPON        = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.WEAPON);
    EnchantmentTarget DIGGER        = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.DIGGER);
    EnchantmentTarget FISHING_ROD   = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.FISHING_ROD);
    EnchantmentTarget TRIDENT       = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.TRIDENT);
    EnchantmentTarget BREAKABLE     = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.BREAKABLE);
    EnchantmentTarget BOW           = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.BOW);
    EnchantmentTarget WEARABLE      = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.WEARABLE);
    EnchantmentTarget CROSSBOW      = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.CROSSBOW);
    EnchantmentTarget VANISHABLE    = VANILLA.get(net.minecraft.enchantment.EnchantmentTarget.VANISHABLE);

    boolean isAcceptableItem(Item item);

    static EnchantmentTarget create(Predicate<Item> isAcceptablePredicate) {
        return new EnchantmentTargetImpl(isAcceptablePredicate);
    }
}
