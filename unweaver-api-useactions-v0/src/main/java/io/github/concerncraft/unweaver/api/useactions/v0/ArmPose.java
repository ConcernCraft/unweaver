package io.github.concerncraft.unweaver.api.useactions.v0;

import io.github.concerncraft.unweaver.api.enums.ExtendedEnum;
import io.github.concerncraft.unweaver.api.enums.VanillaEnumFactory;
import io.github.concerncraft.unweaver.impl.enums.CachedVanillaEnumFactory;
import io.github.concerncraft.unweaver.impl.useactions.v0.ArmPoseImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

/**
 * A custom arm pose for items.
 *
 * @author leocth
 * @version 0.2.0
 */
@Environment(EnvType.CLIENT)
public interface ArmPose extends ExtendedEnum<BipedEntityModel.ArmPose> {

    VanillaEnumFactory<BipedEntityModel.ArmPose, ArmPose> VANILLA
            = new CachedVanillaEnumFactory<>(ArmPoseImpl::new);

    /**
     * Returns whether the arm pose requires both arms. If true, then any arm pose on the off hand
     * will not be used or displayed. If false, both arms display their
     * @return whether the arm pose requires both arms
     */
    boolean requiresBothArms();

    <T extends LivingEntity> void setLeftArmAngles(BipedEntityModel<T> model, T entity);
    <T extends LivingEntity> void setRightArmAngles(BipedEntityModel<T> model, T entity);

    interface Builder {
        Builder requiresBothArms();

        Builder leftArmAngles(ArmAngleSetter setter);
        Builder rightArmAngles(ArmAngleSetter setter);

        ArmPose build();

        static Builder create() {
            return new ArmPoseImpl.Builder();
        }
    }

    interface ArmAngleSetter {
        <T extends LivingEntity> void setAngles(BipedEntityModel<T> model, T entity);
    }
}
