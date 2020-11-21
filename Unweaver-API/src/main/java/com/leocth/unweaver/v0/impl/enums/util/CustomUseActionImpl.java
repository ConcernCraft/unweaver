package com.leocth.unweaver.v0.impl.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import org.jetbrains.annotations.Nullable;

public class CustomUseActionImpl implements UseAction {

    private final ArmPoseFactory armPoseContext;
    private final ConsumingItemCallback consumptionEffectSpawner;

    public CustomUseActionImpl(Builder builder) {
        this.armPoseContext = builder.armPoseFactory;
        this.consumptionEffectSpawner = builder.consumptionCallback;
    }

    @Nullable
    @Override
    public net.minecraft.util.UseAction getVanilla() {
        return null;
    }

    @Override
    public ArmPoseFactory getArmPoseFactory() {
        return armPoseContext;
    }

    @Override
    public ConsumingItemCallback getConsumptionCallback() {
        return consumptionEffectSpawner;
    }
}
