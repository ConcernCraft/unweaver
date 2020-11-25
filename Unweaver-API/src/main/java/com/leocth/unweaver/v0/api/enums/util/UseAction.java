package com.leocth.unweaver.v0.api.enums.util;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.impl.enums.util.UseActionImpl;
import org.jetbrains.annotations.Nullable;

/**
 * A custom use action.
 *
 * @see net.minecraft.util.UseAction
 * @author leocth
 * @since 0.1.0
 */
public interface UseAction extends ExtendedEnum<net.minecraft.util.UseAction> {

    VanillaFactory<net.minecraft.util.UseAction, UseAction> VANILLA
            = new CachedVanillaFactory<>(UseActionImpl::new);

    @Nullable ArmPoseFactory getArmPoseFactory();
    @Nullable ConsumeItemCallback getConsumeItemCallback();

    interface Builder {

        Builder armPose(ArmPoseFactory context);
        Builder onConsumeItem(ConsumeItemCallback callback);

        UseAction build();

        static Builder create() {
            return new UseActionImpl.Builder();
        }
    }

}
