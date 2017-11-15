package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.ExpandableRequestBuilder;
import io.evanwong.oss.hipchat.v2.commons.GrantType;
import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class OauthTokenRequestBuilder extends RequestBuilder<OauthTokenRequest> {

    private GrantType grantType;
    private String scope;

    private String userName;
    private String userId;
    private String code;
    private String clientName;
    private String redirectUri;
    private String password;
    private String groupId;
    private String refreshToken;

    public OauthTokenRequestBuilder(GrantType grantType, String scope, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(null, baseUrl, httpClient, executorService);
        this.grantType = grantType;
    }

    public OauthTokenRequestBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public OauthTokenRequestBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public OauthTokenRequestBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public OauthTokenRequestBuilder setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public OauthTokenRequestBuilder setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OauthTokenRequestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public OauthTokenRequestBuilder setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public OauthTokenRequestBuilder setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    @Override
    public OauthTokenRequest<AccessToken> build() {
        switch (grantType) {
            case CLIENT_CREDENTIALS:
                return new OauthTokenRequest<>(userName, grantType, scope, baseUrl, httpClient, executorService);
            case PASSWORD:
                return new OauthTokenRequest<>(userName, password, grantType, scope, baseUrl, httpClient, executorService);
            case AUTHORIZATION_CODE:
                return new OauthTokenRequest<>(userId, code, clientName, redirectUri, groupId, grantType, scope, baseUrl, httpClient, executorService);
            case REFRESH_TOKEN:
                return new OauthTokenRequest<>(userId, groupId, refreshToken, grantType, scope, baseUrl, httpClient, executorService);
            default:
                throw new RuntimeException("Unsupported grant type: " + grantType);
        }
    }
}
