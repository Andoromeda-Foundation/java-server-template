package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.gps.GpsDTO;
import com.powerbroker.resource.service.GpsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/gps")
public class GpsController extends AbstractCRUDHandler<Long, GpsDTO, GpsService> {

}
