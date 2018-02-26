package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.UnlockKeyRecordDTO;
import com.powerbroker.resource.service.UnlockKeyRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/unlockKeyRecord")
public class UnlockKeyRecordController extends AbstractCRUDHandler<Long, UnlockKeyRecordDTO, UnlockKeyRecordService> {

}
