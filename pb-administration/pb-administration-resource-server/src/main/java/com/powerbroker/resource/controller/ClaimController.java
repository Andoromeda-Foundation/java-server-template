package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.ClaimDTO;
import com.powerbroker.resource.service.ClaimService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/claim")
public class ClaimController extends AbstractCRUDHandler<Long, ClaimDTO, ClaimService> {

}
