package com.leocth.unweaver.v0.mixin;

import net.minecraft.server.command.PlaySoundCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

// thanks ytg!
@Mixin(PlaySoundCommand.class)
public class PlaySoundCommandMixin {
    // double modifyargs to maintain max compat
    @ModifyArg(
        method = "makeArgumentsForCategory",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/brigadier/arguments/FloatArgumentType;floatArg(FF)Lcom/mojang/brigadier/arguments/FloatArgumentType;",
            ordinal = 0
        ),
        index = 0
    )
    private static float yeetLowerLimit(float min, float max) {
        return Float.MIN_VALUE;
    }

    @ModifyArg(
            method = "makeArgumentsForCategory",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/brigadier/arguments/FloatArgumentType;floatArg(FF)Lcom/mojang/brigadier/arguments/FloatArgumentType;",
                    ordinal = 0
            ),
            index = 1
    )
    private static float yeetUpperLimit(float min, float max) {
        return Float.MAX_VALUE;
    }

}
