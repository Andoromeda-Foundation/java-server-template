package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.AttendanceDTO;
import com.powerbroker.resource.service.AttendanceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController extends AbstractCRUDHandler<Long, AttendanceDTO, AttendanceService> {

}