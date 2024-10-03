package org.example.chat;

import org.example.chat.entity.Chat;
import org.example.chat.entity.Message;
import org.example.chat.entity.User;
import org.example.chat.event.MessageQueuedEvent;

public interface DomainService {
    MessageQueuedEvent validateAndInitialMessage(User sender, Chat chat, Message message);
}
