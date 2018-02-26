package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerCutDTO;
import com.powerbroker.resource.service.PowerCutService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerCut")
public class PowerCutController extends AbstractCRUDHandler<Long, PowerCutDTO, PowerCutService> {

}