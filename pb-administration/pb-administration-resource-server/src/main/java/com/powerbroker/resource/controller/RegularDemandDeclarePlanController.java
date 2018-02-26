package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RegularDemandDeclarePlanDTO;
import com.powerbroker.resource.service.RegularDemandDeclarePlanService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/regularDemandDeclarePlan")
public class RegularDemandDeclarePlanController extends AbstractCRUDHandler<Long, RegularDemandDeclarePlanDTO, RegularDemandDeclarePlanService> {

}