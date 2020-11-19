package com.leocth.unweaver.v0.api.util;

import com.leocth.unweaver.v0.api.ExtendedEnum;
import com.leocth.unweaver.v0.impl.util.UseActionImpl;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Items;

import static net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;

public abstract class UseAction implements ExtendedEnum<net.minecraft.util.UseAction> {

    public static final UseAction NONE;
    public static final UseAction EAT;
    public static final UseAction DRINK;
    public static final UseAction BLOCK;
    public static final UseAction BOW;
    public static final UseAction SPEAR;
    public static final UseAction CROSSBOW;
    public static final UseAction SPYGLASS;

    static {
        NONE = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.fixed(ArmPose.EMPTY))
                .vanilla(net.minecraft.util.UseAction.NONE)
                .build();
        EAT = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.fixed(ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.EAT)
                .build();
        DRINK = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.fixed(ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.DRINK)
                .build();
        BLOCK = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.whenUsing(ArmPose.BLOCK, ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.BLOCK)
                .build();
        BOW = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.whenUsing(ArmPose.BOW_AND_ARROW, ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.BOW)
                .build();
        SPEAR = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.whenUsing(ArmPose.THROW_SPEAR, ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.SPEAR)
                .build();
        CROSSBOW = new UseActionImpl.Builder()
                .armPose((player, hand, stack) -> {
                    if (ArmPoseContext.isUsingItem(player, hand) && hand == player.getActiveHand())
                        return ArmPose.CROSSBOW_CHARGE;
                    else if (!player.handSwinging && stack.isOf(Items.CROSSBOW) && CrossbowItem.isCharged(stack))
                        return ArmPose.CROSSBOW_HOLD;
                    else
                        return ArmPose.ITEM;
                })
                .vanilla(net.minecraft.util.UseAction.CROSSBOW)
                .build();
        SPYGLASS = new UseActionImpl.Builder()
                .armPose(ArmPoseContext.whenUsing(ArmPose.SPYGLASS, ArmPose.ITEM))
                .vanilla(net.minecraft.util.UseAction.SPYGLASS)
                .build();
    }
}
