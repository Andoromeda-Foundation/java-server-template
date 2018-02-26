package com.powerbroker.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author william
 */
@Component
public class LogoutSuccessService extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {


    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "authorization";

    @Resource
    private TokenStore redisTokenStore;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication)
            throws IOException, ServletException {

        String token = request.getHeader(HEADER_AUTHORIZATION);

        if (null != token && token.startsWith(BEARER_AUTHENTICATION)) {

            OAuth2AccessToken oAuth2AccessToken = redisTokenStore.readAccessToken(token.split(" ")[1]);

            if (null != oAuth2AccessToken) {
                redisTokenStore.removeAccessToken(oAuth2AccessToken);
            }

        }

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
