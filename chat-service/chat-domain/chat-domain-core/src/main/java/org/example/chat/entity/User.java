package org.example.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.chat.exception.UserIsNotValidException;
import org.example.chatsystem.entity.BaseEntity;
import org.example.chatsystem.valueobject.UserId;

@Getter
@Setter
@AllArgsConstructor
public class User extends BaseEntity<UserId> {
    private final String phoneNumber;
    private String userName;
    private String name;
    private String bio;

    void ValidateUser() {
        if (userName.isEmpty()) {
            throw new UserIsNotValidException("UserName is empty");
        }
    }
}
