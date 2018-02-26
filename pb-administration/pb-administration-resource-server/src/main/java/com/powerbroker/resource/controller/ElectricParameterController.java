package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.ElectricParameterDTO;
import com.powerbroker.resource.service.ElectricParameterService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/electricParameter")
public class ElectricParameterController extends AbstractCRUDHandler<Long, ElectricParameterDTO, ElectricParameterService> {

}
