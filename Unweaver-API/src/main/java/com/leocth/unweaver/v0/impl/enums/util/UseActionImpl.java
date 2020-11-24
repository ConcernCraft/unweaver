package com.leocth.unweaver.v0.impl.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;

public class UseActionImpl extends AbstractExtendedEnum<net.minecraft.util.UseAction> implements UseAction {

    private final ArmPoseFactory armPoseContext;
    private final ConsumeItemCallback consumptionEffectSpawner;

    public UseActionImpl(Builder builder) {
        super(null);
        this.armPoseContext = builder.armPoseFactory;
        this.consumptionEffectSpawner = builder.consumeItemCallback;
    }

    public UseActionImpl(net.minecraft.util.UseAction vanilla) {
        super(vanilla);
        this.armPoseContext = null;
        this.consumptionEffectSpawner = null;
    }

    @Override
    public ArmPoseFactory getArmPoseFactory() {
        return armPoseContext;
    }

    @Override
    public ConsumeItemCallback getConsumptionCallback() {
        return consumptionEffectSpawner;
    }

    public static class Builder implements UseAction.Builder {
        public ArmPoseFactory armPoseFactory;
        public ConsumeItemCallback consumeItemCallback;

        public Builder armPose(ArmPoseFactory context) {
            this.armPoseFactory = context;
            return this;
        }

        public Builder onConsumeItem(ConsumeItemCallback callback) {
            this.consumeItemCallback = callback;
            return this;
        }

        public UseAction build() {
            return new UseActionImpl(this);
        }
    }
}
