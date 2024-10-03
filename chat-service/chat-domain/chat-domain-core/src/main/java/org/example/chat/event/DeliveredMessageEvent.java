package org.example.chat.event;

import org.example.chat.entity.Message;

import java.time.ZonedDateTime;

public class DeliveredMessageEvent extends MessageEvent {
    public DeliveredMessageEvent(Message message, ZonedDateTime createdAt) {
        super(message, createdAt);
    }
}
