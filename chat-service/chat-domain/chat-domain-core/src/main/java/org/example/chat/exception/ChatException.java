package org.example.chat.exception;

import org.example.chatsystem.exception.DomainException;

public class ChatException extends DomainException {
    public ChatException(String message) {
        super(message);
    }

    public ChatException(String message, Throwable cause) {
        super(message, cause);
    }
}
