package com.leocth.unweaver.v0.impl.server.command;

import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.api.registries.world.DifficultyRegistry;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

public class ExtendedDifficultyCommand {
    private static final DynamicCommandExceptionType FAILURE_EXCEPTION
            = new DynamicCommandExceptionType((object) -> new TranslatableText("commands.difficulty.failure", object));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal("difficulty");

        for (Difficulty difficulty : DifficultyRegistry.INSTANCE.values()) {
            builder
                .then(
                    CommandManager
                        .argument("difficulty", IdentifierArgumentType.identifier())
                        .executes(
                            (commandContext) -> execute(commandContext.getSource(), difficulty)
                        )
                );
        }

        dispatcher.register(
            builder
                .requires(
                    (serverCommandSource) -> serverCommandSource.hasPermissionLevel(2)
                )
                .executes(
                    (commandContext) -> {
                        //Difficulty difficulty = commandContext.getSource().getWorld().getDifficulty();
                        /*
                        commandContext.getSource().sendFeedback(
                            new TranslatableText(
                                "commands.difficulty.query",
                                difficulty.getTranslatableName()
                            ), false
                        );
                         */
                        return 0;//difficulty.getId();
                    }
                )
            );
    }

    public static int execute(ServerCommandSource source, Difficulty difficulty) throws CommandSyntaxException {
        /*
        MinecraftServer minecraftServer = source.getMinecraftServer();
        if (minecraftServer.getSaveProperties().getDifficulty() == difficulty) {
            throw FAILURE_EXCEPTION.create(difficulty.getName());
        } else {
            minecraftServer.setDifficulty(difficulty, true);
            source.sendFeedback(new TranslatableText("commands.difficulty.success", new Object[]{difficulty.getTranslatableName()}), true);
            return 0;
        }
         */
        return 0;
    }

}
