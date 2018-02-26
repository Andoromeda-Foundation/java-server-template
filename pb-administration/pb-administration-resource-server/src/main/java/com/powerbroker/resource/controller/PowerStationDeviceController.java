package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerStationDeviceDTO;
import com.powerbroker.resource.service.PowerStationDeviceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerStationDevice")
public class PowerStationDeviceController extends AbstractCRUDHandler<Long, PowerStationDeviceDTO, PowerStationDeviceService> {

}