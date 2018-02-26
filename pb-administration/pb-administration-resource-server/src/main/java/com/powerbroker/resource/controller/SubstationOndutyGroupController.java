package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.SubstationOndutyGroupDTO;
import com.powerbroker.resource.service.SubstationOndutyGroupService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/substationOndutyGroup")
public class SubstationOndutyGroupController extends AbstractCRUDHandler<Long, SubstationOndutyGroupDTO, SubstationOndutyGroupService> {

}