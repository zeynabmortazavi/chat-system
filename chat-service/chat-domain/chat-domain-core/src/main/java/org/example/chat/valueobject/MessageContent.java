package org.example.chat.valueobject;

import org.example.chat.exception.MessageException;

import java.util.List;
import java.util.Objects;

public record MessageContent(String text, List<String> emojis) {
    public void validate() {
        if (Objects.isNull(text)) {
            throw new MessageException("Message content is empty");
        }
        if (text.length() > 5000) {
            throw new MessageException("Text message must not exceed 5000 characters.");
        }
        if (emojis.size() > 10) {
            throw new MessageException("A message cannot have more than 10 emojis.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageContent that = (MessageContent) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
