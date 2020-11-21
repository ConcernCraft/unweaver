package com.leocth.unweaver.v0.api.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.util.CustomUseActionImpl;
import com.leocth.unweaver.v0.impl.enums.util.VanillaUseActionImpl;
import org.jetbrains.annotations.Nullable;

public interface UseAction extends ExtendedEnum<net.minecraft.util.UseAction> {

    UseAction NONE     = VanillaUseActionImpl.get(net.minecraft.util.UseAction.NONE);
    UseAction EAT      = VanillaUseActionImpl.get(net.minecraft.util.UseAction.EAT);
    UseAction DRINK    = VanillaUseActionImpl.get(net.minecraft.util.UseAction.DRINK);
    UseAction BLOCK    = VanillaUseActionImpl.get(net.minecraft.util.UseAction.BLOCK);
    UseAction BOW      = VanillaUseActionImpl.get(net.minecraft.util.UseAction.BOW);
    UseAction SPEAR    = VanillaUseActionImpl.get(net.minecraft.util.UseAction.SPEAR);
    UseAction CROSSBOW = VanillaUseActionImpl.get(net.minecraft.util.UseAction.CROSSBOW);
    UseAction SPYGLASS = VanillaUseActionImpl.get(net.minecraft.util.UseAction.SPYGLASS);

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
            return new CustomUseActionImpl(this);
        }
    }

}
