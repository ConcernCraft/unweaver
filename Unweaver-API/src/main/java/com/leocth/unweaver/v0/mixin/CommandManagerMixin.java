package com.leocth.unweaver.v0.mixin;

import com.leocth.unweaver.v0.impl.server.command.ExtendedDifficultyCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommandManager.class)
public class CommandManagerMixin {

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/command/DifficultyCommand;register(Lcom/mojang/brigadier/CommandDispatcher;)V"))
    private void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        ExtendedDifficultyCommand.register(dispatcher);
    }
}
