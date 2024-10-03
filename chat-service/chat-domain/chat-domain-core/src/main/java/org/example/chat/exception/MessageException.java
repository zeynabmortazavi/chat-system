package org.example.chat.exception;

import org.example.chatsystem.exception.DomainException;

public class MessageException extends DomainException {
    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
