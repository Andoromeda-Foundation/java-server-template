package com.powerbroker.resource.controller;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.UserDTO;
import com.powerbroker.resource.service.UserService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends AbstractCRUDHandler<Long, UserDTO, UserService> {

    @RequestMapping(
            value = {"/me"},
            method = {RequestMethod.GET}
    )
    public GenericResponse<UserDTO> profile(Principal principal) throws Exception {
        return ControllerTemplate.call((response) -> {
            PBAuthUser pbAuthUser = (PBAuthUser) ((OAuth2Authentication) principal).getPrincipal();
            response.setData(this.getService().retrieve(pbAuthUser.getId()));
            response.setResult(true);
        });
    }
}
