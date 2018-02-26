package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.UpdaterDTO;
import com.powerbroker.resource.service.UpdaterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/updater")
public class UpdaterController extends AbstractCRUDHandler<Long, UpdaterDTO, UpdaterService> {

    @PostMapping(value = "/latest")
    public GenericResponse<UpdaterDTO> retrieve(@RequestBody @Valid UpdaterDTO request) throws Exception {

        return ControllerTemplate.call((GenericResponse<UpdaterDTO> response) -> {

            Page<UpdaterDTO> data = ((PageableService) getService()).list(request,
                    new PageRequest(setAndGetPageNumber(null), setAndGetPageSize(null)));

            if (data.hasContent()) {
                response.setData(data.getContent().get(0));
            }
            response.setResult(true);
        });
    }
}
