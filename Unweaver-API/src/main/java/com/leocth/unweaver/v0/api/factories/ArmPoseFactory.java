package com.leocth.unweaver.v0.api.factories;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Factory type that returns a {@link BipedEntityModel.ArmPose} with context.
 *
 * @author leocth
 * @since 0.1.0
 */
@Environment(EnvType.CLIENT)
@FunctionalInterface
public interface ArmPoseFactory {

    @NotNull BipedEntityModel.ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand, ItemStack stack);

    /**
     * Creates a new {@link ArmPoseFactory} with a fixed and constant arm pose regardless of context.
     *
     * @param armPose the arm pose
     */
    @Contract("_ -> new")
    static ArmPoseFactory fixed(@NotNull BipedEntityModel.ArmPose armPose) {
        return (player, hand, stack) -> armPose;
    }

    /**
     * Creates a new {@link ArmPoseFactory} that uses one arm pose when using the item, and another otherwise.
     * Useful for edible, drinkable, or otherwise usable item.
     *
     * @param armPose the arm pose to use when using the item
     * @param otherwise the arm pose to use when <em>not</em> using the item
     */
    @Contract("_, _ -> new")
    static ArmPoseFactory whenUsing(@NotNull BipedEntityModel.ArmPose armPose, @NotNull BipedEntityModel.ArmPose otherwise) {
        return (player, hand, stack) -> isUsingItem(player, hand) ? armPose : otherwise;
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
