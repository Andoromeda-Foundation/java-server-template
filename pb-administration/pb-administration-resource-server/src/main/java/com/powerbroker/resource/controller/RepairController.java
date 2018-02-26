package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RepairDTO;
import com.powerbroker.resource.service.RepairService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/repair")
public class RepairController extends AbstractCRUDHandler<Long, RepairDTO, RepairService> {

}
