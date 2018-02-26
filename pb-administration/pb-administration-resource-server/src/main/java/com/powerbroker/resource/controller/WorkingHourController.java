package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.WorkingHourDTO;
import com.powerbroker.resource.service.WorkingHourService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/workingHour")
public class WorkingHourController extends AbstractCRUDHandler<Long, WorkingHourDTO, WorkingHourService> {

}
