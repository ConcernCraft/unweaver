package com.leocth.unweaver.v0.api.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.impl.enums.util.UseActionImpl;
import org.jetbrains.annotations.Nullable;

public interface UseAction extends ExtendedEnum<net.minecraft.util.UseAction> {

    VanillaFactory<net.minecraft.util.UseAction, UseAction> VANILLA
            = new CachedVanillaFactory<>(UseActionImpl::new);

    UseAction NONE     = VANILLA.get(net.minecraft.util.UseAction.NONE);
    UseAction EAT      = VANILLA.get(net.minecraft.util.UseAction.EAT);
    UseAction DRINK    = VANILLA.get(net.minecraft.util.UseAction.DRINK);
    UseAction BLOCK    = VANILLA.get(net.minecraft.util.UseAction.BLOCK);
    UseAction BOW      = VANILLA.get(net.minecraft.util.UseAction.BOW);
    UseAction SPEAR    = VANILLA.get(net.minecraft.util.UseAction.SPEAR);
    UseAction CROSSBOW = VANILLA.get(net.minecraft.util.UseAction.CROSSBOW);
    UseAction SPYGLASS = VANILLA.get(net.minecraft.util.UseAction.SPYGLASS);

    @Nullable ArmPoseFactory getArmPoseFactory();
    @Nullable ConsumeItemCallback getConsumptionCallback();

    interface Builder {

        Builder armPose(ArmPoseFactory context);
        Builder onConsumeItem(ConsumeItemCallback callback);

        UseAction build();

        static Builder create() {
            return new UseActionImpl.Builder();
        }
    }

}
