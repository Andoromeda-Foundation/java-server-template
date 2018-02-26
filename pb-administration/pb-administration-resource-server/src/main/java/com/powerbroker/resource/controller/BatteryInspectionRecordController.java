package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.BatteryInspectionRecordDTO;
import com.powerbroker.resource.service.BatteryInspectionRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/batteryInspectionRecord")
public class BatteryInspectionRecordController extends AbstractCRUDHandler<Long, BatteryInspectionRecordDTO, BatteryInspectionRecordService> {

}
