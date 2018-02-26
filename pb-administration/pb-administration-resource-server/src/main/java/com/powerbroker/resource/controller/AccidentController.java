package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.AccidentDTO;
import com.powerbroker.resource.service.AccidentService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/accident")
public class AccidentController extends AbstractCRUDHandler<Long, AccidentDTO, AccidentService> {

}
