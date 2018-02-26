package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RfidDTO;
import com.powerbroker.resource.service.RfidService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/rfid")
public class RfidController extends AbstractCRUDHandler<Long, RfidDTO, RfidService> {

}
