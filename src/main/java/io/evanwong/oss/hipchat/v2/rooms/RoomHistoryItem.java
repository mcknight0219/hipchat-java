package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.Mention;

import java.util.List;

abstract class RoomHistoryItem {
    private String id;
    private String type;
    private String message;
    private String date;
    private List<Mention> mentions;

    private final String[] VALID_MESSAGE_TYPE = {"message", "guest_access", "topic", "notification"};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public List<Mention> getMentions() {
        return mentions;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        boolean isCorectType = false;
        for (String t : VALID_MESSAGE_TYPE) {
            if (t.compareTo(type) == 0) {
                isCorectType = true;
                break;
            }
        }
        if (!isCorectType) {
            throw new IllegalArgumentException("not valid message type");
        }
        this.type = type;
    }
}
