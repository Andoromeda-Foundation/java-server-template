package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.NonRunningRecordDTO;
import com.powerbroker.resource.service.NonRunningRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/nonRunningRecord")
public class NonRunningRecordController extends AbstractCRUDHandler<Long, NonRunningRecordDTO, NonRunningRecordService> {

}
