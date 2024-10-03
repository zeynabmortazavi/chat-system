package org.example.chat.event;

import org.example.chat.entity.Message;

import java.time.ZonedDateTime;

public class MessageQueuedEvent extends MessageEvent {

    public MessageQueuedEvent(Message message, ZonedDateTime createdAt) {
        super(message, createdAt);
    }
}
