package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.GrantType;
import io.evanwong.oss.hipchat.v2.commons.Request;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class OauthTokenRequest<T> extends Request<T> {

    private static final Logger log = LoggerFactory.getLogger(OauthTokenRequest.class);

    private String scope;
    private GrantType grantType;

    // Credential
    private String userName;
    private String userId;
    private String code;
    private String clientName;
    private String redirectUri;
    private String password;
    private String groupId;
    private String refreshToken;

    OauthTokenRequest(GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(null, baseUrl, httpClient, executorService);
        this.grantType = grantType;
        this.scope = scope;
    }

    // Password
    OauthTokenRequest(String userName, String password, GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this(grantType, scope, baseUrl, httpClient, executorService);
        this.userName = userName;
        this.password = password;
    }

    // client-credential
    OauthTokenRequest(String userName, GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this(grantType, scope, baseUrl, httpClient, executorService);
        this.userName = userName;
    }

    // authorization code
    OauthTokenRequest(String userId, String code, String clientName, String redirecUri, String groupId, GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this(grantType, scope, baseUrl, httpClient, executorService);
        this.userId = userId;
        this.code = code;
        this.clientName = clientName;
        this.redirectUri = redirecUri;
        this.groupId = groupId;
    }

    // refresh token
    OauthTokenRequest(String userId, String groupId, String refreshToken, GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this(grantType, scope, baseUrl, httpClient, executorService);
        this.userId = userId;
        this.groupId = groupId;
        this.refreshToken = refreshToken;
    }

    @Override
    protected HttpResponse request() throws IOException {
        Map<String, Object> params = toQueryMap();
        String encodedPath = getEncodedPath();
        log.info("Post - path: {}, params: {}", encodedPath, params);

        HttpPost httpPost = new HttpPost(baseUrl + encodedPath);
        httpPost.setEntity(new StringEntity(objectWriter.writeValueAsString(params), Consts.UTF_8));
        return httpClient.execute(httpPost, HttpClientContext.create());
    }

    @Override
    protected String getPath() {
        return "/oauth/token";
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        switch (grantType) {
            case PASSWORD:
                params.put("username", userName);
                params.put("password", password);
                break;
            case CLIENT_CREDENTIALS:
                params.put("username", userName);
                break;
            case AUTHORIZATION_CODE:
                params.put("user_id", userId);
                params.put("code", code);
                params.put("client_name", clientName);
                params.put("redirect_uri", redirectUri);
                params.put("group_id", groupId);
                break;
            case REFRESH_TOKEN:
                params.put("user_id", userId);
                params.put("client_name", clientName);
                params.put("group_id", groupId);
                params.put("refresh_token", refreshToken);
                break;
            default:
                throw new RuntimeException("Unsupported grant type: " + grantType);
        }

        return params;
    }
}
