package org.example.chat.event;

import org.example.chat.entity.Message;
import org.example.chatsystem.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class MessageEvent implements DomainEvent<Message> {
    private final Message message;
    private final ZonedDateTime createdAt;

    public MessageEvent(Message message, ZonedDateTime createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public Message getMessage() {
        return message;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
