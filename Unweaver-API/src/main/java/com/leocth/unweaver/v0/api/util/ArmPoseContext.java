package com.leocth.unweaver.v0.api.util;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

@FunctionalInterface
public interface ArmPoseContext {
    BipedEntityModel.ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand, ItemStack stack);

    static ArmPoseContext fixed(BipedEntityModel.ArmPose armPose) {
        return (player, hand, stack) -> armPose;
    }

    static ArmPoseContext whenUsing(BipedEntityModel.ArmPose armPose, BipedEntityModel.ArmPose otherwise) {
        return (player, hand, stack) -> isUsingItem(player, hand) ? armPose : otherwise;
    }

    static boolean isUsingItem(AbstractClientPlayerEntity player, Hand hand) {
        return player.getActiveHand() == hand && player.getItemUseTimeLeft() > 0;
    }
}
