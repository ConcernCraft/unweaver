package io.github.concerncraft.unweaver.api.useactions.v0;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Interface that handles spawning of consumption effects (e.g. eat/drink sounds, item eat particles), for custom use actions.
 *
 * @author leocth
 * @since 0.2.0s
 */
@FunctionalInterface
public interface ConsumptionEffectSpawner {

    void spawn(@NotNull LivingEntity entity, ItemStack stack, int particleCount);

    static ConsumptionEffectSpawner whenUsing(@NotNull ConsumptionEffectSpawner spawner) {
        return (entity, stack, particleCount) -> {
            if (isUsingItem(entity, stack))
                spawner.spawn(entity, stack, particleCount);
        };
    }

    static boolean isUsingItem(LivingEntity entity, ItemStack stack) {
        return !stack.isEmpty() && entity.isUsingItem();
    }

}
