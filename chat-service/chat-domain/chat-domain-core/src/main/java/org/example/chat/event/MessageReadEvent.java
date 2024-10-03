package org.example.chat.event;

import org.example.chat.entity.Message;

import java.time.ZonedDateTime;

public class MessageReadEvent extends MessageEvent {
    public MessageReadEvent(Message message, ZonedDateTime createdAt) {
        super(message, createdAt);
    }
}
