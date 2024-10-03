package org.example.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.chat.exception.ChatException;
import org.example.chat.valueobject.ChatType;
import org.example.chatsystem.entity.AggregateRoot;
import org.example.chatsystem.valueobject.ChatId;
import org.example.chatsystem.valueobject.MessageId;
import org.example.chatsystem.valueobject.UserId;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Chat extends AggregateRoot<ChatId> {
    private final ChatType chatType;
    private List<UserId> participants;
    private List<MessageId> messages;

    public Chat(ChatType chatType, List<UserId> participants) {
        this.chatType = chatType;
        this.participants = participants;
    }

    void validateChat() {
        if (participants == null || participants.size() < 2) {
            throw new ChatException("Chat must have at least 2 participants");
        }
    }

    Chat initializeChat(List<UserId> participants) {
        ChatType chatType = ChatType.OneToOne;
        if (participants.size() > 2) {
            chatType = ChatType.OneToMany;
        }
        return new Chat(chatType, participants);
    }

    public void addParticipant(UserId userId) {
        if (participants == null) {
            participants = new ArrayList<>();
            participants.add(userId);
        }
        if (!participants.contains(userId)) {
            participants.add(userId);
        }
    }

    public void removeParticipant(UserId userId) {
        if (participants.contains(userId)) {
            participants.remove(userId);
        }
    }

    public void addMessage(MessageId messageId) {
        if (messages == null) {
            messages = new ArrayList<>();
            messages.add(messageId);
        }
        if (!messages.contains(messageId)) {
            messages.add(messageId);
        }
    }

}
