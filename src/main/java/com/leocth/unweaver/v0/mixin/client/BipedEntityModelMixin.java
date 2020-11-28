package com.leocth.unweaver.v0.mixin.client;

import com.leocth.unweaver.v0.api.enums.client.render.entity.ArmPose;
import com.leocth.unweaver.v0.impl.traits.BipedEntityModelTrait;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead, BipedEntityModelTrait {
    private ArmPose leftArmPose;
    private ArmPose rightArmPose;

    @Override
    public ArmPose getLeftArmPose() {
        return leftArmPose;
    }

    @Override
    public void setLeftArmPose(ArmPose pose) {
        this.leftArmPose = pose;
    }

    @Override
    public ArmPose getRightArmPose() {
        return rightArmPose;
    }

    @Override
    public void setRightArmPose(ArmPose pose) {
        this.rightArmPose = pose;
    }

    @Inject(
        method = "method_30154",
        at = @At("HEAD"),
        require = 0,
        cancellable = true
    )
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void setRightArmPose(T livingEntity, CallbackInfo ci) {
        if (rightArmPose != null && rightArmPose.isCustom()) {
            rightArmPose.setRightArmAngles((BipedEntityModel<T>)(Object)this, livingEntity);
            ci.cancel();
        }
    }

    @Inject(
            method = "method_30155",
            at = @At("HEAD"),
            require = 0,
            cancellable = true
    )
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void setLeftArmPose(T livingEntity, CallbackInfo ci) {
        if (leftArmPose != null && leftArmPose.isCustom()) {
            leftArmPose.setRightArmAngles((BipedEntityModel<T>)(Object)this, livingEntity);
            ci.cancel();
        }
    }
}
