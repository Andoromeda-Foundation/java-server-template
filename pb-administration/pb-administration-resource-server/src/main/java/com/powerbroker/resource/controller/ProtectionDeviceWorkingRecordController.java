package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.ProtectionDeviceWorkingRecordDTO;
import com.powerbroker.resource.service.ProtectionDeviceWorkingRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/protectionDeviceAction")
public class ProtectionDeviceWorkingRecordController extends AbstractCRUDHandler<Long, ProtectionDeviceWorkingRecordDTO, ProtectionDeviceWorkingRecordService> {

}
