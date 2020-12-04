package io.github.concerncraft.unweaver.mixin.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ArmPose;
import io.github.concerncraft.unweaver.impl.useactions.v0.BipedEntityModelTrait;
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
    private ArmPose customLeftArmPose;
    private ArmPose customRightArmPose;

    @Override
    public ArmPose getLeftArmPose() {
        return customLeftArmPose;
    }

    @Override
    public void setLeftArmPose(ArmPose pose) {
        this.customLeftArmPose = pose;
    }

    @Override
    public ArmPose getRightArmPose() {
        return customRightArmPose;
    }

    @Override
    public void setRightArmPose(ArmPose pose) {
        this.customRightArmPose = pose;
    }

    @Inject(
        method = "positionRightArm",
        at = @At("HEAD"),
        require = 0,
        cancellable = true
    )
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void setRightArmPose(T livingEntity, CallbackInfo ci) {
        if (customRightArmPose != null && customRightArmPose.isCustom()) {
            customRightArmPose.setRightArmAngles((BipedEntityModel<T>)(Object)this, livingEntity);
            ci.cancel();
        }
    }

    @Inject(
        method = "positionLeftArm",
        at = @At("HEAD"),
        require = 0,
        cancellable = true
    )
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void setLeftArmPose(T livingEntity, CallbackInfo ci) {
        if (customLeftArmPose != null && customLeftArmPose.isCustom()) {
            customLeftArmPose.setLeftArmAngles((BipedEntityModel<T>)(Object)this, livingEntity);
            ci.cancel();
        }
    }
}
