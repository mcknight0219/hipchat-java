package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.DeleteRequest;
import io.evanwong.oss.hipchat.v2.commons.NoContent;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteSessionRequest extends DeleteRequest<NoContent> {
    DeleteSessionRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    protected String getPath() {
        return "/oauth/token/" + accessToken;
    }
}
