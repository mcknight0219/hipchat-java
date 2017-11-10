package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.ExpandableRequestBuilder;
import org.apache.http.client.HttpClient;
import java.util.concurrent.ExecutorService;

public class ViewRoomHistoryRequestBuilder extends ExpandableRequestBuilder<ViewRoomHistoryRequestBuilder, ViewRoomHistoryRequest> {

    private String roomIdOrName;
    private Integer maxResults;
    private Boolean reverse;
    private Integer startIndex;
    private Boolean includeDeleted;
    private String  date;
    private String  timezone;
    private String  endDate;

    public ViewRoomHistoryRequestBuilder(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        if (roomIdOrName == null || roomIdOrName.isEmpty()) {
            throw new IllegalArgumentException("roomIdOrName is required");
        }
        this.roomIdOrName = roomIdOrName;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public ViewRoomHistoryRequestBuilder setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setReverse(Boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public ViewRoomHistoryRequest build() {
        if (accessToken == null) {
            throw new IllegalArgumentException("accessToken is required");
        }
        ViewRoomHistoryRequest request = new ViewRoomHistoryRequest(roomIdOrName, maxResults, reverse, startIndex, includeDeleted, date, timezone, endDate, accessToken, baseUrl, httpClient, executorService);
        if (!expansions.isEmpty()) {
            expansions.forEach(title -> request.addExpansion(title));
        }
        return request;
    }
}
