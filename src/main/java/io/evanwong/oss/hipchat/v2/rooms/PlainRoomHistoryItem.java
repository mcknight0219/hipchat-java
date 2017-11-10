package io.evanwong.oss.hipchat.v2.rooms;

public class PlainRoomHistoryItem extends RoomHistoryItem {
    private String from;
    private String color;

    private final String[] VALID_COLORS = {"yellow", "green", "red", "purple", "gray"};

    public String getFrom() {
        return from;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        boolean isCorrect = false;
        for (String c : VALID_COLORS) {
            if (c.compareTo(color) == 0) {
                isCorrect = true;
                break;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException("not a valid color");
        }
        this.color = color;
    }
}
