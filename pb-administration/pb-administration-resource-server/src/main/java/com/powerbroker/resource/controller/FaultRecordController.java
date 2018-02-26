package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.FaultRecordDTO;
import com.powerbroker.resource.service.FaultRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/faultRecord")
public class FaultRecordController extends AbstractCRUDHandler<Long, FaultRecordDTO, FaultRecordService> {

}