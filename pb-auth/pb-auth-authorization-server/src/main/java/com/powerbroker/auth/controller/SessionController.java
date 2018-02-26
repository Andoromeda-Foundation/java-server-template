package com.powerbroker.auth.controller;

import com.powerbroker.auth.service.SessionService;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/session")
public class SessionController {

    @Resource
    private SessionService sessionService;

    @GetMapping(value = "/listBy/{clientId}")
    public GenericResponse<Collection<OAuth2AccessToken>> list(@PathVariable("clientId") String clientId) throws Exception {
        return ControllerTemplate.call((GenericResponse<Collection<OAuth2AccessToken>> response) -> {

            Collection<OAuth2AccessToken> tokens = sessionService.countCurrentUser(clientId).stream().filter(token -> !token.isExpired()).distinct().collect(Collectors.toList());

            response.setData(tokens);
            response.setResult(true);
        });
    }
}
