package com.leocth.unweaver.v0.mixin.client;

import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

// thanks ytg!
@Mixin(SoundSystem.class)
public class SoundSystemMixin {
    // double modifyargs to maintain max compat
    @ModifyArg(
            method = "getAdjustedPitch",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"),
            index = 1
    )
    private float yeetLowerLimit(float pitch, float min, float max) {
        return Float.MIN_VALUE;
    }

    @ModifyArg(
            method = "getAdjustedPitch",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"),
            index = 2
    )
    private float yeetUpperLimit(float pitch, float min, float max) {
        return Float.MAX_VALUE;
    }
}
