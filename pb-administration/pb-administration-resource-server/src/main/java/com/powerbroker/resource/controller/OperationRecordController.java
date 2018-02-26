package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.OperationRecordDTO;
import com.powerbroker.resource.service.OperationRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/operationRecord")
public class OperationRecordController extends AbstractCRUDHandler<Long, OperationRecordDTO, OperationRecordService> {

}