package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.InspectionDTO;
import com.powerbroker.resource.service.InspectionService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/inspection")
public class InspectionController extends AbstractCRUDHandler<Long, InspectionDTO, InspectionService> {

}
