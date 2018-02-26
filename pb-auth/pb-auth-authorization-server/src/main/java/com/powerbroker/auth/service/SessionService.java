package com.powerbroker.auth.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author william
 */
@Component
public class SessionService {

    @Resource
    private TokenStore redisTokenStore;

    public Collection<OAuth2AccessToken> countCurrentUser(String clientId) {

        Collection<OAuth2AccessToken> allTokens = redisTokenStore.findTokensByClientId(clientId);

        return allTokens;
    }

}
