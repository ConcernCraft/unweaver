package com.leocth.unweaver.v0.api.callbacks;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ConsumingItemCallback {

    void call(@NotNull LivingEntity entity, ItemStack stack, int particleCount);

    static ConsumingItemCallback whenUsing(@NotNull ConsumingItemCallback callback) {
        return (entity, stack, particleCount) -> {
            if (isUsingItem(entity, stack))
                callback.call(entity, stack, particleCount);
        };
    }

    static boolean isUsingItem(LivingEntity entity, ItemStack stack) {
        return !stack.isEmpty() && entity.isUsingItem();
    }

}
