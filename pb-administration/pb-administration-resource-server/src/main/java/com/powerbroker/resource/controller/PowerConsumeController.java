package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerConsumeDTO;
import com.powerbroker.resource.service.PowerConsumeService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerConsume")
public class PowerConsumeController extends AbstractCRUDHandler<Long, PowerConsumeDTO, PowerConsumeService> {

}