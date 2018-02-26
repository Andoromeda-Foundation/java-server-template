package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.ElectricalTestingDTO;
import com.powerbroker.resource.service.ElectricalTestingService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/electricalTesting")
public class ElectricalTestingController extends AbstractCRUDHandler<Long, ElectricalTestingDTO, ElectricalTestingService> {


}