package com.leocth.unweaver.v0.impl.util;

import com.google.common.annotations.VisibleForTesting;
import com.leocth.unweaver.v0.api.util.ArmPoseContext;
import com.leocth.unweaver.v0.api.util.UseAction;
import org.jetbrains.annotations.Nullable;


public class UseActionImpl extends UseAction {

    public final ArmPoseContext armPosePredicate;
    private final net.minecraft.util.UseAction vanilla;

    public UseActionImpl(Builder builder) {
        this.armPosePredicate = builder.armPosePredicate;
        this.vanilla = builder.vanilla;
    }

    @Nullable
    @Override
    public net.minecraft.util.UseAction getVanilla() {
        return vanilla;
    }

    public static class Builder {
        public ArmPoseContext armPosePredicate;
        public net.minecraft.util.UseAction vanilla = null;

        public Builder armPose(ArmPoseContext predicate) {
            this.armPosePredicate = predicate;
            return this;
        }

        @VisibleForTesting
        public Builder vanilla(net.minecraft.util.UseAction vanilla) {
            this.vanilla = vanilla;
            return this;
        }

        public UseAction build() {
            return new UseActionImpl(this);
        }
    }


}
