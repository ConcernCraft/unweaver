package com.leocth.unweaver.v0.api.enums.client.render.entity;

import com.leocth.unweaver.v0.api.enums.ExtendedEnum;
import com.leocth.unweaver.v0.api.enums.VanillaFactory;
import com.leocth.unweaver.v0.impl.enums.CachedVanillaFactory;
import com.leocth.unweaver.v0.impl.enums.client.render.entity.ArmPoseImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public interface ArmPose extends ExtendedEnum<BipedEntityModel.ArmPose> {

    VanillaFactory<BipedEntityModel.ArmPose, ArmPose> VANILLA
            = new CachedVanillaFactory<>(ArmPoseImpl::new);

    boolean requiresBothArms();

    <T extends LivingEntity> void setLeftArmAngles(BipedEntityModel<T> model, T entity);
    <T extends LivingEntity> void setRightArmAngles(BipedEntityModel<T> model, T entity);

    interface Builder {
        Builder requiresBothArms();

        Builder leftArmAngles(ArmAngleSetter setter);
        Builder rightArmAngles(ArmAngleSetter setter);

        ArmPose build();
    }

    interface ArmAngleSetter {
        <T extends LivingEntity> void setAngles(BipedEntityModel<T> model, T entity);
    }
}
