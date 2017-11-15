package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteSessionRequestBuilder extends RequestBuilder<DeleteSessionRequest> {
    public DeleteSessionRequestBuilder(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    public DeleteSessionRequest build() {
        return new DeleteSessionRequest(accessToken, baseUrl, httpClient, executorService);
    }
}
