package com.leocth.unweaver.v0.impl.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumingItemCallback;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.AbstractVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.blocks.enums.InstrumentImpl;
import net.minecraft.block.enums.Instrument;
import org.jetbrains.annotations.Nullable;

public class UseActionImpl extends AbstractExtendedEnum<net.minecraft.util.UseAction> implements UseAction {

    public static final AbstractVanillaFactory<net.minecraft.util.UseAction, UseActionImpl> VANILLA
            = new AbstractVanillaFactory<net.minecraft.util.UseAction, UseActionImpl>() {
        @Override
        protected UseActionImpl createCustom(net.minecraft.util.UseAction vanilla) {
            return new UseActionImpl(vanilla);
        }
    };

    private final ArmPoseFactory armPoseContext;
    private final ConsumingItemCallback consumptionEffectSpawner;

    public UseActionImpl(Builder builder) {
        super(null);
        this.armPoseContext = builder.armPoseFactory;
        this.consumptionEffectSpawner = builder.consumptionCallback;
    }

    private UseActionImpl(net.minecraft.util.UseAction vanilla) {
        super(vanilla);
        this.armPoseContext = null;
        this.consumptionEffectSpawner = null;
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