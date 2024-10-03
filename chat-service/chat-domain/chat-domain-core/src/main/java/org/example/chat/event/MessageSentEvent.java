package org.example.chat.event;

import org.example.chat.entity.Message;

import java.time.ZonedDateTime;

public class MessageSentEvent extends MessageEvent {
    public MessageSentEvent(Message message, ZonedDateTime createdAt) {
        super(message, createdAt);
    }
}
