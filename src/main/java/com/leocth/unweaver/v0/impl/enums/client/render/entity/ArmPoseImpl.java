package com.leocth.unweaver.v0.impl.enums.client.render.entity;

import com.leocth.unweaver.v0.api.enums.client.render.entity.ArmPose;
import com.leocth.unweaver.v0.impl.enums.AbstractExtendedEnum;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class ArmPoseImpl extends AbstractExtendedEnum<BipedEntityModel.ArmPose> implements ArmPose {

    private final boolean requiresBothArms;
    private final ArmAngleSetter leftArmAnglesSetter;
    private final ArmAngleSetter rightArmAnglesSetter;

    public ArmPoseImpl(Builder builder) {
        super(null);
        this.requiresBothArms = builder.requiresBothArms;
        this.leftArmAnglesSetter = builder.leftArmAnglesSetter;
        this.rightArmAnglesSetter = builder.rightArmAnglesSetter;
    }

    public ArmPoseImpl(BipedEntityModel.ArmPose vanilla) {
        super(vanilla);
        this.requiresBothArms = vanilla.method_30156();
        this.leftArmAnglesSetter = null;
        this.rightArmAnglesSetter = null;
    }

    @Override
    public boolean requiresBothArms() {
        return requiresBothArms;
    }

    @Override
    public <T extends LivingEntity> void setLeftArmAngles(BipedEntityModel<T> model, T entity) {
        leftArmAnglesSetter.setAngles(model, entity);
    }

    @Override
    public <T extends LivingEntity> void setRightArmAngles(BipedEntityModel<T> model, T entity) {
        rightArmAnglesSetter.setAngles(model, entity);
    }

    @Nullable
    @Override
    public BipedEntityModel.ArmPose getVanilla() {
        return null;
    }

    public static class Builder implements ArmPose.Builder {

        private boolean requiresBothArms = false;
        private ArmAngleSetter leftArmAnglesSetter;
        private ArmAngleSetter rightArmAnglesSetter;

        @Override
        public ArmPose.Builder requiresBothArms() {
            this.requiresBothArms = true;
            return this;
        }

        @Override
        public ArmPose.Builder leftArmAngles(ArmAngleSetter setter) {
            this.leftArmAnglesSetter = setter;
            return this;
        }

        @Override
        public ArmPose.Builder rightArmAngles(ArmAngleSetter setter) {
            this.rightArmAnglesSetter = setter;
            return this;
        }

        @Override
        public ArmPose build() {
            return new ArmPoseImpl(this);
        }
    }
}
