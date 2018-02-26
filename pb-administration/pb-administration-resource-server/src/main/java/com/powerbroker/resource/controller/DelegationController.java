package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.model.DelegationDTO;
import com.powerbroker.resource.service.DelegationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/delegation")
public class DelegationController extends AbstractCRUDHandler<Long, DelegationDTO, DelegationService> {

    @PutMapping(value = "/approve/{id}")
    public GenericResponse<Boolean> approve(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<Boolean> response) -> {

            Long transferId = ValueUtil.idDecode(id);
            if (null != transferId) {
                response.setData(getService().approve(transferId));
            }
            response.setResult(true);
        });
    }

    @PutMapping(value = "/reject/{id}")
    public GenericResponse<Boolean> reject(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<Boolean> response) -> {

            Long transferId = ValueUtil.idDecode(id);
            if (null != transferId) {
                response.setData(getService().reject(transferId));
            }
            response.setResult(true);
        });
    }
}