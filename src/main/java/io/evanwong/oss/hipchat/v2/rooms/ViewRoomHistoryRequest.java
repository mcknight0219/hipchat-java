package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import io.evanwong.oss.hipchat.v2.commons.NoContent;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ViewRoomHistoryRequest extends GetRequest<NoContent>{

    private String roomIdOrName;

    private Integer maxResults;
    private Boolean reverse;
    private Integer startIndex;
    private Boolean includeDeleted;
    private String  date;
    private String  timezone;
    private String  endDate;


    ViewRoomHistoryRequest(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
       this(roomIdOrName, null, null, null, null, null, null, null, accessToken, baseUrl, httpClient, executorService);
    }

    ViewRoomHistoryRequest(String roomIdOrName, Integer maxResults, Boolean reverse, Integer startIndex, Boolean includeDeleted, String date, String timezone, String endDate, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
        this.maxResults = maxResults;
        this.reverse = reverse;
        this.startIndex = startIndex;
        this.includeDeleted = includeDeleted;
        this.date = date;
        this.timezone = timezone;
        this.endDate = endDate;
    }

    @Override
    protected String getPath() {
        return String.format("/room/%s/history", roomIdOrName);
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        if (maxResults != null && maxResults > 0 && maxResults < 100) {
            params.put("max-results", maxResults);
        }
        if (reverse != null) {
            params.put("reverse", reverse);
        }
        if (startIndex != null) {
            params.put("start-index", startIndex);
        }
        if (includeDeleted != null) {
            params.put("include_deleted", includeDeleted);
        }
        if (date != null) {
            params.put("date", date);
        }
        if (timezone != null) {
            params.put("timezone", timezone);
        }
        if (endDate != null) {
            params.put("end-date", endDate);
        }

        return params;
    }

}
