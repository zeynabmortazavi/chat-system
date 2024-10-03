package org.example.chatsystem.valueobject;

import java.util.UUID;

public class MessageId extends BaseId<UUID> {
    protected MessageId(UUID value) {
        super(value);
    }
}
