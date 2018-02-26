package com.powerbroker.common.utils;

/**
 * @author william
 */
public interface Constants {

    String OAUTH2_DEFAULT_RESOURCE_ID = "power-broker";
    String OAUTH2_DEFAULT_SCOPE = "read|write|trust";
    String OAUTH2_DEFAULT_GRANT_TYPE = "password|refresh_token";
    int OAUTH2_DEFAULT_ACCESS_TOKEN_VALIDITY = 43200;
    int OAUTH2_DEFAULT_REFRESH_TOKEN_VALIDITY = 2592000;

    int USER_AUTH_TYPE = 1;
    int CLIENT_USER_TYPE = 2;
}
