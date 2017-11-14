package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class OauthTokenRequest<T> extends Request<T> {

    private static final Logger log = LoggerFactory.getLogger(OauthTokenRequest.class);

    protected OauthTokenRequest(String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(null, baseUrl, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws
}
