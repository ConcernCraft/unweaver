package io.github.concerncraft.unweaver.api.useactions.v0;

import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

/**
 * {@link Item}s inheriting from this interface will use override
 * the arm pose and use effects defined and fixed in place in vanilla (via {@link net.minecraft.util.UseAction}).
 *
 * @author leocth
 * @since 0.2.0
 */
public interface UseActionContainer {

    @Nullable ArmPoseFactory getArmPoseFactory();

    @Nullable ConsumptionEffectSpawner getConsumptionEffectSpawner();

}
