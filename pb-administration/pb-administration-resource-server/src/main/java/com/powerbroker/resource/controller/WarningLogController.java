package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.WarningLogDTO;
import com.powerbroker.resource.service.WarningLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/warningLog")
public class WarningLogController extends AbstractCRUDHandler<Long, WarningLogDTO, WarningLogService> {

    @GetMapping(value = "/list/{num}")
    public GenericResponse<List<WarningLogDTO>> list(@PathVariable(value = "num") Integer num) throws Exception {

        return ControllerTemplate.call((GenericResponse<List<WarningLogDTO>> response) -> {

            Page<WarningLogDTO> data = ((PageableService) getService()).listActive(
                    new PageRequest(setAndGetPageNumber(num), setAndGetPageSize(null),
                            new Sort(Sort.Direction.DESC, "occurredAt")));

            extractResponse(response, data);
        });
    }

}
