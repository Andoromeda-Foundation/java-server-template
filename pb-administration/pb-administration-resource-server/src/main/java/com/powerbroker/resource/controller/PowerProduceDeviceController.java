package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerProduceDeviceDTO;
import com.powerbroker.resource.service.PowerProduceDeviceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerProduceDevice")
public class PowerProduceDeviceController extends AbstractCRUDHandler<Long, PowerProduceDeviceDTO, PowerProduceDeviceService> {

}