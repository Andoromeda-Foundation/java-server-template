package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.MaintenanceServiceDTO;
import com.powerbroker.resource.service.MaintenanceServiceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/maintenanceService")
public class MaintenanceServiceController extends AbstractCRUDHandler<Long, MaintenanceServiceDTO, MaintenanceServiceService> {

}
