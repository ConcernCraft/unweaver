package com.leocth.unweaver.v0.api.containers.util;

import com.leocth.unweaver.v0.api.enums.util.UseAction;
import net.minecraft.item.ItemStack;

/**
 * Items inheriting from this interface will use a custom {@link UseAction} instead of the hardcoded
 * scenarios/conditions defined in vanilla.
 *
 * @author leocth
 * @since 0.1.0
 */
public interface UseActionContainer {
    UseAction getCustomUseAction(ItemStack stack);
}
