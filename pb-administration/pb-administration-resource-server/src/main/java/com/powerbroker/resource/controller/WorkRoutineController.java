package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.WorkRoutineDTO;
import com.powerbroker.resource.service.WorkRoutineService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/workRoutine")
public class WorkRoutineController extends AbstractCRUDHandler<Long, WorkRoutineDTO, WorkRoutineService> {

}