package org.example.chat;

import org.example.chat.entity.Chat;
import org.example.chat.entity.Message;
import org.example.chat.entity.User;
import org.example.chat.event.MessageQueuedEvent;

public class DomainServiceImpl implements DomainService{
    @Override
    public MessageQueuedEvent validateAndInitialMessage(User sender, Chat chat, Message message) {
        return null;
    }
}
