package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.InsuranceDTO;
import com.powerbroker.resource.service.InsuranceService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/insurance")
public class InsuranceController extends AbstractCRUDHandler<Long, InsuranceDTO, InsuranceService> {

}
