package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.VehicleDTO;
import com.powerbroker.resource.service.VehicleService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController extends AbstractCRUDHandler<Long, VehicleDTO, VehicleService> {

}
