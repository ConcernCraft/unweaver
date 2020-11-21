package com.leocth.unweaver.v0.mixin;

import com.leocth.unweaver.v0.api.factories.ArmPoseFactory;
import com.leocth.unweaver.v0.api.enums.util.UseAction;
import com.leocth.unweaver.v0.impl.Opener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {

    @Inject(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"),
            method = "getArmPose",
            locals = LocalCapture.CAPTURE_FAILSOFT,
            require = 0,
            cancellable = true
    )
    private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir, ItemStack stack) {
        UseAction useAction = Opener.open(stack).getUseAction();
        if (useAction.isCustom()) {
            ArmPoseFactory factory = useAction.getArmPoseFactory();
            if (factory != null)
                cir.setReturnValue(factory.getArmPose(player, hand, stack));
        }
    }
}
