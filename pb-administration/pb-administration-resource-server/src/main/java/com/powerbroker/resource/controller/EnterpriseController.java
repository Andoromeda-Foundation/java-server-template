package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.EnterpriseDTO;
import com.powerbroker.resource.service.EnterpriseService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/enterprise")
public class EnterpriseController extends AbstractCRUDHandler<Long, EnterpriseDTO, EnterpriseService> {

}