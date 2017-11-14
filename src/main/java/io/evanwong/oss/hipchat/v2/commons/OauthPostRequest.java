package io.evanwong.oss.hipchat.v2.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class OauthTokenRequest<T> extends Request<T> {

    private String scope;
    private GrantType grantType;

    protected OauthTokenRequest(GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(null, baseUrl, httpClient, executorService);
        this.grantType = grantType;
        this.scope = scope;
    }

    /*
    The caller should be responsible for passing in correct credentials that
    satisfy the grant type
     */
    public void setCredential(Map<String, String> credentials) {

    }

    @Override
    protected HttpResponse request() throws IOException {

    }

    @Override
    protected String getPath() {
        return "/oauth/token";
    }

    @Override
    protected Map<String, Object> toQueryMap() {

    }
}
