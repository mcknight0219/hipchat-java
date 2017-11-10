package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.evanwong.oss.hipchat.v2.commons.PagingLinks;

import java.util.List;

public class RoomHistory {
    private List<RoomHistoryItem> items;
    private PagingLinks links;
    private Integer startIndex;
    private Integer maxResults;

    public RoomHistory() {

    }

    public List<RoomHistoryItem> getItems() {
        return items;
    }

    public void setItems(List<RoomHistoryItem> items) {
        this.items = items;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonSetter("startIndex")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonSetter("maxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
