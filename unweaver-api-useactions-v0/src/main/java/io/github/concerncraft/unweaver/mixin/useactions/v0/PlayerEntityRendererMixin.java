package io.github.concerncraft.unweaver.mixin.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ArmPose;
import io.github.concerncraft.unweaver.api.useactions.v0.ArmPoseFactory;
import io.github.concerncraft.unweaver.api.useactions.v0.UseActionContainer;
import io.github.concerncraft.unweaver.impl.useactions.v0.BipedEntityModelTrait;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

    @Shadow
    private static BipedEntityModel.ArmPose shadow$getArmPose(AbstractClientPlayerEntity player, Hand hand) {
        throw new AssertionError();
    }

    @Inject(
        method = "setModelPose",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/PlayerEntityRenderer;getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;",
            ordinal = 0
        ),
        locals = LocalCapture.CAPTURE_FAILSOFT,
        require = 0,
        cancellable = true
    )
    private void setModelPose(AbstractClientPlayerEntity player, CallbackInfo ci, PlayerEntityModel<AbstractClientPlayerEntity> playerEntityModel) {
        ArmPose mainArmPose = getArmPose(player, Hand.MAIN_HAND);
        ArmPose offArmPose = getArmPose(player, Hand.OFF_HAND);
        if (mainArmPose.requiresBothArms()) {
            offArmPose = ArmPose.VANILLA.get(
                player.getOffHandStack().isEmpty() ? BipedEntityModel.ArmPose.EMPTY : BipedEntityModel.ArmPose.ITEM
            );
        }
        BipedEntityModelTrait model = (BipedEntityModelTrait) playerEntityModel;
        if (player.getMainArm() == Arm.RIGHT) {
            model.setRightArmPose(mainArmPose);
            model.setLeftArmPose(offArmPose);
        } else {
            model.setRightArmPose(offArmPose);
            model.setLeftArmPose(mainArmPose);
        }
    }

    private static ArmPose getArmPose(AbstractClientPlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (item instanceof UseActionContainer) {
            ArmPoseFactory factory = ((UseActionContainer) item).getArmPoseFactory();
            if (factory != null)
                return factory.getArmPose(player, hand);
        }
        return ArmPose.VANILLA.get(shadow$getArmPose(player, hand));
    }

}
