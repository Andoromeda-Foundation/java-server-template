package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DeviceDTO;
import com.powerbroker.resource.service.DeviceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/device")
public class DeviceController extends AbstractCRUDHandler<Long, DeviceDTO, DeviceService> {

}