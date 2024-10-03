package org.example.chatsystem.valueobject;

import java.util.Date;
import java.util.Objects;

public record MessageStatus(Status status, Date timestamp)  {
    public enum Status{ QUEUED, SENT, READ, FAILED}

    public boolean isValidStatusChange(Status currentStatus, Status newStatus) {
        switch (currentStatus) {
            case FAILED, READ -> {
                return false;
            }
            case QUEUED -> {
                return newStatus == Status.SENT || newStatus == Status.FAILED;
            }
            case SENT -> {
                return newStatus == Status.READ;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatus that = (MessageStatus) o;
        return status == that.status && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, timestamp);
    }
}
