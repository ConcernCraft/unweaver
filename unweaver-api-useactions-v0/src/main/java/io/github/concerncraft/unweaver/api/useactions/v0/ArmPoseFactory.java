package io.github.concerncraft.unweaver.api.useactions.v0;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.NotNull;

/**
 * Factory type that returns a {@link ArmPose} with context.
 *
 * @author leocth
 * @since 0.2.0
 */
@Environment(EnvType.CLIENT)
@FunctionalInterface
public interface ArmPoseFactory {

    @NotNull ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand);

    /**
     * Creates a new {@link ArmPoseFactory} with a fixed and constant arm pose regardless of context.
     *
     * @param armPose the arm pose
     */
    static ArmPoseFactory fixed(@NotNull ArmPose armPose) {
        return (player, hand) -> armPose;
    }

    /**
     * Creates a new {@link ArmPoseFactory} that uses one arm pose when using the item, and another otherwise.
     * Useful for edible, drinkable, or otherwise usable item.
     *
     * @param armPose the arm pose to use when using the item
     * @param otherwise the arm pose to use when <em>not</em> using the item
     */
    static ArmPoseFactory whenUsing(@NotNull ArmPose armPose, @NotNull ArmPose otherwise) {
        return (player, hand) -> isUsingItem(player, hand) ? armPose : otherwise;
    }

    /**
     * Tests if the player is using an item.
     *
     * @param player the player
     * @param hand the hand the item is held in
     */
    static boolean isUsingItem(@NotNull AbstractClientPlayerEntity player, @NotNull Hand hand) {
        return player.getActiveHand() == hand && player.getItemUseTimeLeft() > 0;
    }
}
