package org.example.chatsystem.valueobject;

import java.util.UUID;

public class ChatId extends BaseId<UUID> {
    protected ChatId(UUID value) {
        super(value);
    }
}
