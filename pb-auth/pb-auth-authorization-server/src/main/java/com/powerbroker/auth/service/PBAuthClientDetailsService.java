package com.powerbroker.auth.service;

import com.powerbroker.auth.dao.ClientDetailDAO;
import com.powerbroker.auth.entity.ClientDetail;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Service("pbAuthClientDetailsService")
public class PBAuthClientDetailsService implements ClientDetailsService {

    @Resource
    private ClientDetailDAO clientDetailDAO;

    @Override
    @Transactional(readOnly = true)
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        ClientDetail clientDetail = clientDetailDAO.findByClientId(clientId);

        return buildClientDetailsForAuthentication(clientDetail);
    }

    private ClientDetails buildClientDetailsForAuthentication(ClientDetail clientDetail) {

        Assert.notNull(clientDetail, "client detail should not be null");

        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(clientDetail.getClientId());
        clientDetails.setClientSecret(clientDetail.getClientSecret());
        clientDetails.setResourceIds(Arrays.asList(clientDetail.getResourceIds().split("\\|")));
        clientDetails.setScope(Arrays.asList(clientDetail.getScope().split("\\|")));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList(clientDetail.getAuthorizedGrantTypes().split("\\|")));
        String webServerRedirectURI = clientDetail.getWebServerRedirectURI();
        if (StringUtils.hasText(webServerRedirectURI)) {
            clientDetails.setRegisteredRedirectUri(Arrays.stream(webServerRedirectURI.split("\\|")).collect(Collectors.toSet()));
        }
        // TODO:
//         clientDetails.setAuthorities(Arrays.asList(clientDetail.getAuthorities().split("\\|")));
        clientDetails.setAccessTokenValiditySeconds(clientDetail.getAccessTokenValidity());
        clientDetails.setRefreshTokenValiditySeconds(clientDetail.getRefreshTokenValidity());
        // TODO:
        // clientDetails.setAdditionalInformation();
        String autoApprove = clientDetail.getAutoApprove();
        if (StringUtils.hasText(autoApprove)) {
            clientDetails.setAutoApproveScopes(Arrays.asList(autoApprove.split("\\|")));
        }


        return clientDetails;
    }
}
