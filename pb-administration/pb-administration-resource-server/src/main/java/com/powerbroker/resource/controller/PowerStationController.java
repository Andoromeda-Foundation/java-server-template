package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.PowerStationDTO;
import com.powerbroker.resource.service.PowerStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.powerbroker.resource.service.PowerStationService.POWER_STATION_ONLINE;

/**
 * @author william
 */
@Slf4j
@RestController
@RequestMapping(value = "/powerStation")
public class PowerStationController extends AbstractCRUDHandler<Long, PowerStationDTO, PowerStationService> {

    @GetMapping(value = "/listAllOnline")
    public GenericResponse<List<PowerStationDTO>> listAllOnline() throws
            Exception {

        return ControllerTemplate.call((GenericResponse<List<PowerStationDTO>> response) -> {

            int pageNumber = 0;
            int pageSize = 1000;
            PowerStationDTO request = new PowerStationDTO();
            request.setState(POWER_STATION_ONLINE);

            log.info("param info {}", request);

            Page<PowerStationDTO> data = ((PageableService) getService()).list(request, new PageRequest(pageNumber, pageSize));

            extractResponse(response, data);
        });
    }
}