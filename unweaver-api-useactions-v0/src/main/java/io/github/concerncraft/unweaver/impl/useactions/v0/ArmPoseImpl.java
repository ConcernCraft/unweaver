package io.github.concerncraft.unweaver.impl.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ArmPose;
import io.github.concerncraft.unweaver.impl.enums.AbstractExtendedEnum;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

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
        this.requiresBothArms = vanilla.isTwoHanded();
        this.leftArmAnglesSetter = null;
        this.rightArmAnglesSetter = null;
    }

    @Override
    public boolean requiresBothArms() {
        return requiresBothArms;
    }

    @Override
    public <T extends LivingEntity> void setLeftArmAngles(BipedEntityModel<T> model, T entity) {
        if (leftArmAnglesSetter != null)
            leftArmAnglesSetter.setAngles(model, entity);
    }

    @Override
    public <T extends LivingEntity> void setRightArmAngles(BipedEntityModel<T> model, T entity) {
        if (rightArmAnglesSetter != null)
            rightArmAnglesSetter.setAngles(model, entity);
    }

    @Nullable
    @Override
    public BipedEntityModel.ArmPose getVanilla() {
        return vanilla;
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
