package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerConsumeDeviceDTO;
import com.powerbroker.resource.service.PowerConsumeDeviceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerConsumeDevice")
public class PowerConsumeDeviceController extends AbstractCRUDHandler<Long, PowerConsumeDeviceDTO, PowerConsumeDeviceService> {

}