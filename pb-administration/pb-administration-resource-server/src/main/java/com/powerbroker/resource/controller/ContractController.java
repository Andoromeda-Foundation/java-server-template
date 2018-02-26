package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.ContractDTO;
import com.powerbroker.resource.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/contract")
public class ContractController extends AbstractCRUDHandler<Long, ContractDTO, ContractService> {

}