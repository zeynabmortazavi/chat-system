package org.example.chat.exception;

import org.example.chatsystem.exception.DomainException;

public class UserIsNotValidException extends DomainException {
    public UserIsNotValidException(String message) {
        super(message);
    }

    public UserIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
