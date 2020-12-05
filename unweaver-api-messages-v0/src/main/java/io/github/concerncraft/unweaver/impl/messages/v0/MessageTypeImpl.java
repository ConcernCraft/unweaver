package io.github.concerncraft.unweaver.impl.messages.v0;

import com.google.common.collect.ImmutableList;
import io.github.concerncraft.unweaver.api.messages.v0.MessageType;
import io.github.concerncraft.unweaver.impl.enums.AbstractExtendedEnum;
import io.github.concerncraft.unweaver.util.SidedUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.ClientChatListener;

import java.util.List;

public class MessageTypeImpl extends AbstractExtendedEnum<net.minecraft.network.MessageType> implements MessageType {

    private boolean chat;
    private boolean interruptsNarration;
    private boolean queueMessages;
    @Environment(EnvType.CLIENT)
    private List<ClientChatListener> chatListeners;

    private MessageTypeImpl(Builder builder) {
        super(null);
        this.chat = builder.chat;
        this.interruptsNarration = builder.interruptsNarration;
        this.queueMessages = builder.queueMessages;
        if (SidedUtils.isClient()) {
            this.chatListeners = builder.chatListeners;
        }
    }

    public MessageTypeImpl(net.minecraft.network.MessageType vanilla) {
        super(vanilla);
        this.chat = vanilla == net.minecraft.network.MessageType.CHAT;
        this.interruptsNarration = vanilla.interruptsNarration();
        this.queueMessages = vanilla != net.minecraft.network.MessageType.CHAT;
        if (SidedUtils.isClient()) {
            this.chatListeners = null;
        }
    }

    @Override
    public boolean isChat() {
        return chat;
    }

    @Override
    public boolean interruptsNarration() {
        return interruptsNarration;
    }

    @Override
    public boolean queuesMessages() {
        return queueMessages;
    }

    @Override
    public List<ClientChatListener> getClientChatListeners() {
        return chatListeners;
    }

    public static class Builder implements MessageType.Builder {

        private boolean chat;
        private boolean interruptsNarration;
        private boolean queueMessages;
        @Environment(EnvType.CLIENT)
        private List<ClientChatListener> chatListeners;

        @Override
        public MessageType.Builder chat(boolean chat) {
            this.chat = chat;
            this.interruptsNarration = !chat;
            this.queueMessages = chat;
            return this;
        }

        @Override
        public MessageType.Builder interruptNarration() {
            this.interruptsNarration = true;
            return this;
        }

        @Override
        public MessageType.Builder queueMessages() {
            this.queueMessages = true;
            return this;
        }

        @Override
        public MessageType.Builder chatListeners(List<ClientChatListener> listeners) {
            if (SidedUtils.isClient()) {
                this.chatListeners = ImmutableList.copyOf(listeners);
            }
            return this;
        }

        @Override
        public MessageType.Builder chatListeners(ClientChatListener... listeners) {
            if (SidedUtils.isClient()) {
                this.chatListeners = ImmutableList.copyOf(listeners);
            }
            return this;
        }

        @Override
        public MessageType build() {
            return new MessageTypeImpl(this);
        }
    }
}
