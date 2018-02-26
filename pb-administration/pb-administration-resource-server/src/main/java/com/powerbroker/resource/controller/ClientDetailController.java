package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.ClientDetailDTO;
import com.powerbroker.resource.service.ClientDetailService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/clientDetail")
public class ClientDetailController extends AbstractCRUDHandler<Long, ClientDetailDTO, ClientDetailService> {

    @PostMapping(value = "/reset")
    public GenericResponse<ClientDetailDTO> reset(@RequestBody @Valid ClientDetailDTO request, BindingResult bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<ClientDetailDTO> response) -> {

            response.setData(getService().resetSecret(request));
            response.setResult(true);
        });
    }
}
