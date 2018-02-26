package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.MaintenanceRecordDTO;
import com.powerbroker.resource.service.MaintenanceRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/maintenanceRecord")
public class MaintenanceRecordController extends AbstractCRUDHandler<Long, MaintenanceRecordDTO, MaintenanceRecordService> {

}
