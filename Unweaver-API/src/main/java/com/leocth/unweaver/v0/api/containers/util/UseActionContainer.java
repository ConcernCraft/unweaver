package com.leocth.unweaver.v0.api.containers.util;

import com.leocth.unweaver.v0.api.enums.util.UseAction;
import net.minecraft.item.ItemStack;

public interface UseActionContainer {
    UseAction getCustomUseAction(ItemStack stack);
}
