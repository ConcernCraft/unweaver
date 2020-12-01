package com.leocth.unweaver.v0.test;

import com.leocth.unweaver.v0.api.callbacks.ConsumeItemCallback;
import com.leocth.unweaver.v0.api.containers.util.UseActionContainer;
import com.leocth.unweaver.v0.api.enums.client.render.entity.ArmPose;
import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class TestItem extends Item implements UseActionContainer {

    public static final ArmPose USE_ARMPOSE
            = ArmPose.Builder.create()
                .leftArmAngles(TestItem::setLeftArmPose) // lambdas dont work here for some reason
                .rightArmAngles(TestItem::setRightArmPose)
                .build();


    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable ArmPoseFactory getArmPoseFactory() {
        return ArmPoseFactory.whenUsing(USE_ARMPOSE, ArmPose.VANILLA.get(BipedEntityModel.ArmPose.ITEM));
    }

    @Override
    public @Nullable ConsumeItemCallback getConsumeItemCallback() {
        return ConsumeItemCallback.whenUsing(
                (entity, stack, particleCount) ->
                        entity.playSound(SoundEvents.ENTITY_PLAYER_SPLASH, 0.5F, 0.1f)
        );
    }


    private static <T extends LivingEntity> void setLeftArmPose(BipedEntityModel<T> model, T entity) {
        model.leftArm.pitch = 2.915f;
        model.leftArm.yaw = -2f;
    }

    private static <T extends LivingEntity> void setRightArmPose(BipedEntityModel<T> model, T entity) {
        model.rightArm.pitch = 2.915f;
        model.rightArm.yaw = -2f;
    }
}
