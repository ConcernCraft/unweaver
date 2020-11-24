package com.leocth.unweaver.v0.impl.server.command;

import com.leocth.unweaver.v0.api.cca.DifficultyComponent;
import com.leocth.unweaver.v0.api.enums.world.Difficulty;
import com.leocth.unweaver.v0.api.registries.world.DifficultyRegistry;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.SaveProperties;

import java.util.Optional;

public class ExtendedDifficultyCommand {
    private static final DynamicCommandExceptionType FAILURE_EXCEPTION
            = new DynamicCommandExceptionType((object) -> new TranslatableText("commands.difficulty.failure", object));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal("difficulty");

        builder
            .then(
                CommandManager
                    .argument("difficulty", IdentifierArgumentType.identifier())
                    .suggests(
                        (ctx, suggestionsBuilder) ->
                            CommandSource.suggestIdentifiers(
                                DifficultyRegistry.INSTANCE.values()
                                    .stream()
                                    .map(Difficulty::getId),
                                suggestionsBuilder
                            )
                    )
                    .executes(
                        ctx ->
                            execute(
                                ctx.getSource(),
                                IdentifierArgumentType.getIdentifier(ctx, "difficulty")
                            )
                    )
            );

        dispatcher.register(
            builder
                .requires(
                    (serverCommandSource) -> serverCommandSource.hasPermissionLevel(2)
                )
                .executes(
                    (commandContext) -> {
                        DifficultyComponent difficultyComponent = DifficultyComponent.get(commandContext.getSource().getWorld());
                        Difficulty difficulty = difficultyComponent.getDifficulty();
                        if (difficulty != null)
                            commandContext.getSource().sendFeedback(
                                new TranslatableText(
                                    "commands.difficulty.query",
                                    difficulty.getTranslatableName()
                                ), false
                            );
                        return 0;//difficulty.getId();
                    }
                )
            );
    }

    public static int execute(ServerCommandSource source, Identifier id) throws CommandSyntaxException {
        Optional<Difficulty> maybeDiff = DifficultyRegistry.INSTANCE.get(id);
        if (maybeDiff.isPresent()) {
            Difficulty difficulty = maybeDiff.get();
            SaveProperties properties = source.getMinecraftServer().getSaveProperties();
            DifficultyComponent diffComponent = DifficultyComponent.get(properties);

            if (diffComponent.getDifficulty() == difficulty) {
                throw FAILURE_EXCEPTION.create(difficulty.getId().toString());
            } else {
                source.sendFeedback(new TranslatableText("commands.difficulty.success", difficulty.getTranslatableName()), true);
                diffComponent.setDifficulty(difficulty);
                if (!difficulty.isCustom())
                    properties.setDifficulty(difficulty.getVanilla());
            }
        }
        return 0;
    }

}
