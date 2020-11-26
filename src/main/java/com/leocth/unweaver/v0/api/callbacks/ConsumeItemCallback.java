package com.leocth.unweaver.v0.api.callbacks;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author leocth
 * @since 0.1.0
 */
@FunctionalInterface
public interface ConsumeItemCallback {

    void call(@NotNull LivingEntity entity, ItemStack stack, int particleCount);

    static ConsumeItemCallback whenUsing(@NotNull ConsumeItemCallback callback) {
        return (entity, stack, particleCount) -> {
            if (isUsingItem(entity, stack))
                callback.call(entity, stack, particleCount);
        };
    }

    static boolean isUsingItem(LivingEntity entity, ItemStack stack) {
        return !stack.isEmpty() && entity.isUsingItem();
    }

}
