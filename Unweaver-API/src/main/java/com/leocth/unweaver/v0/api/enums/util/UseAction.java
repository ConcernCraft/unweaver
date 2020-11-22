package com.leocth.unweaver.v0.api.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.util.UseActionImpl;
import org.jetbrains.annotations.Nullable;

public interface UseAction extends ExtendedEnum<net.minecraft.util.UseAction> {

    UseAction NONE     = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.NONE);
    UseAction EAT      = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.EAT);
    UseAction DRINK    = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.DRINK);
    UseAction BLOCK    = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.BLOCK);
    UseAction BOW      = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.BOW);
    UseAction SPEAR    = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.SPEAR);
    UseAction CROSSBOW = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.CROSSBOW);
    UseAction SPYGLASS = UseActionImpl.VANILLA.get(net.minecraft.util.UseAction.SPYGLASS);

    @Nullable ArmPoseFactory getArmPoseFactory();
    @Nullable ConsumingItemCallback getConsumptionCallback();

    class Builder {
        public ArmPoseFactory armPoseFactory;
        public ConsumingItemCallback consumptionCallback;

        public Builder armPose(ArmPoseFactory context) {
            this.armPoseFactory = context;
            return this;
        }

        public Builder consumptionEffectSpawner(ConsumingItemCallback callback) {
            this.consumptionCallback = callback;
            return this;
        }

        public UseAction build() {
            return new UseActionImpl(this);
        }
    }

}
