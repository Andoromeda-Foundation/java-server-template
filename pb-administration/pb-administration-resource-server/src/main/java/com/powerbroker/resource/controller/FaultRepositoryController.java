package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.FaultRepositoryDTO;
import com.powerbroker.resource.service.FaultRepositoryService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/faultRepository")
public class FaultRepositoryController extends AbstractCRUDHandler<Long, FaultRepositoryDTO, FaultRepositoryService> {

}
