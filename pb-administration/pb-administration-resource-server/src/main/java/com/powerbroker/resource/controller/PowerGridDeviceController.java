package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerGridDeviceDTO;
import com.powerbroker.resource.service.PowerGridDeviceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerGridDevice")
public class PowerGridDeviceController extends AbstractCRUDHandler<Long, PowerGridDeviceDTO, PowerGridDeviceService> {

}