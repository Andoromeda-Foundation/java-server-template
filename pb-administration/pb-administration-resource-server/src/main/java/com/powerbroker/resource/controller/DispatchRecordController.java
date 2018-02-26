package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DispatchRecordDTO;
import com.powerbroker.resource.service.DispatchRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/dispatchRecord")
public class DispatchRecordController extends AbstractCRUDHandler<Long, DispatchRecordDTO, DispatchRecordService> {

}
