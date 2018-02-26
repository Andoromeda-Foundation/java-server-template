package com.powerbroker.resource.controller;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.ClientDTO;
import com.powerbroker.resource.service.ClientService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/client")
public class ClientController extends AbstractCRUDHandler<Long, ClientDTO, ClientService> {

    @RequestMapping(
            value = {"/me"},
            method = {RequestMethod.GET}
    )
    public GenericResponse<ClientDTO> profile(Principal principal) throws Exception {
        return ControllerTemplate.call((response) -> {
            PBAuthUser pbAuthUser = (PBAuthUser) ((OAuth2Authentication) principal).getPrincipal();
            response.setData(this.getService().retrieve(pbAuthUser.getId()));
            response.setResult(true);
        });
    }

}
