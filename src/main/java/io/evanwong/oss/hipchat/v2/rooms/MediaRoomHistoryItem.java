package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.File;
import io.evanwong.oss.hipchat.v2.commons.FromItem;
import io.evanwong.oss.hipchat.v2.commons.Link;

import java.util.List;

public class MediaRoomHistoryItem extends RoomHistoryItem {
    private File file;
    private FromItem from;
    private List<Link> messageLinks;

    public File getFile() {
        return file;
    }

    public FromItem getFrom() {
        return from;
    }

    public List<Link> getMessageLinks() {
        return messageLinks;
    }
}
