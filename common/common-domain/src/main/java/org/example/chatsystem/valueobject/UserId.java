package org.example.chatsystem.valueobject;

import java.util.UUID;

public class UserId extends BaseId<UUID> {
    protected UserId(UUID value) {
        super(value);
    }
}
