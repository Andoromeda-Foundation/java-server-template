package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.gps.AccountDTO;
import com.powerbroker.resource.service.GpsAccountService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/gpsAccount")
public class GAccountController extends AbstractCRUDHandler<Long, AccountDTO, GpsAccountService> {

}
