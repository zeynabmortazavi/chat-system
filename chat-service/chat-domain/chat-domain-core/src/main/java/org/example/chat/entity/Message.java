package org.example.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.chat.exception.MessageException;
import org.example.chat.valueobject.MessageContent;
import org.example.chatsystem.entity.AggregateRoot;
import org.example.chatsystem.valueobject.MessageId;
import org.example.chatsystem.valueobject.MessageStatus;
import org.example.chatsystem.valueobject.UserId;

import java.util.Date;

@Getter
@Setter
public class Message extends AggregateRoot<MessageId> {
    private final MessageContent messageContent;
    //is it better if we have a reference to User entity ?
    private final UserId sender;
    private final UserId recipient;
    private MessageStatus messageStatus;


    public Message(MessageContent messageContent, UserId sender, UserId recipient) {
        this.messageContent = messageContent;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Message createMessage() {
        if (sender == null || recipient == null) {
            throw new MessageException("sender or recipient can not be null");
        }
        messageContent.validate();
        Message message = new Message(messageContent, sender, recipient);
        message.setMessageStatus(new MessageStatus(MessageStatus.Status.QUEUED, new Date()));
        return message;
    }

    public void markMessageAsRead(MessageStatus.Status status) {
        if (!messageStatus.isValidStatusChange(this.messageStatus.status(), status)) {
            throw new MessageException("message status is not valid");
        }
        messageStatus = new MessageStatus(MessageStatus.Status.READ, new Date());
    }

    public void markMessageAsSent(MessageStatus.Status status) {
        if (!messageStatus.isValidStatusChange(this.messageStatus.status(), status)) {
            throw new MessageException("message status is not valid");
        }
        this.messageStatus = new MessageStatus(status, new Date());
    }

    public void markMessageAsDelivered(MessageStatus.Status status) {
        if (!messageStatus.isValidStatusChange(this.messageStatus.status(), status)) {
            throw new MessageException("message status is not valid");
        }
        this.messageStatus = new MessageStatus(status, new Date());
    }

}
