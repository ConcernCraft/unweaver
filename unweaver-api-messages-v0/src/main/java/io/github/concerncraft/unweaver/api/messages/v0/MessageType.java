package io.github.concerncraft.unweaver.api.messages.v0;

import io.github.concerncraft.unweaver.api.enums.ExtendedEnum;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.ClientChatListener;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;

import java.util.List;
import java.util.UUID;

/**
 * A custom message type in parallel to chat, system and game info message types.
 *
 * @see net.minecraft.network.MessageType
 * @author leocth
 * @version 0.3.0
 */
public interface MessageType extends ExtendedEnum<net.minecraft.network.MessageType> {

    /**
     * @return whether messages of this type are treated as chat.
     * @see GameMessageS2CPacket#isNonChat()
     */
    boolean isChat();

    /**
     * Returns whether messages of this type interrupt the current narration of other messages.
     * Intended for "important" messages types like system and game info.
     *
     * @return whether messages of this type interrupt the current narration
     * @see net.minecraft.network.MessageType#interruptsNarration()
     */
    boolean interruptsNarration();

    /**
     * @return whether messages of this type should be queued, instead of being appended directly
     * to the chat HUD.
     * @see net.minecraft.client.gui.hud.ChatHudListener#onChatMessage(net.minecraft.network.MessageType, Text, UUID)
     */
    boolean queuesMessages();

    /**
     * @return a list of chat listeners hooked up to this message type.
     *
     * @see net.minecraft.client.gui.hud.InGameHud#InGameHud(MinecraftClient)
     */
    @Environment(EnvType.CLIENT)
    List<ClientChatListener> getClientChatListeners();

    /**
     * Builder for custom message types.
     */
    interface Builder {

        /**
         * Sets whether messages of this type should be treated as chat.
         * <p>
         * If {@code chat} is true,
         *   sets the message type to not interrupt narrations and queue messages.
         * Otherwise,
         *   sets the message type to interrupt narrations and queue messages.]
         *
         * @param chat should the messages of this type be treated as chat
         * @return this builder
         */
        Builder chat(boolean chat);

        /**
         * Lets messages of this type interrupt the current narrated content.
         * @return this builder
         */
        Builder interruptNarration();

        /**
         * Lets messages of this type be queued instead of added directly to the chat HUD.
         * @return this builder
         */
        Builder queueMessages();

        /**
         * If this method was run on the client, binds chat listeners to this message type.
         * @param listeners chat listeners
         * @return this builder
         */
        Builder chatListeners(List<ClientChatListener> listeners);

        /**
         * If this method was run on the client, binds chat listeners to this message type.
         * @param listeners chat listeners
         * @return this builder
         */
        Builder chatListeners(ClientChatListener... listeners);

        /**
         * @return a new message type with attributes specified with this builder.
         */
        MessageType build();
    }

}
