package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PatrolDTO;
import com.powerbroker.resource.service.PatrolService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/patrol")
public class PatrolController extends AbstractCRUDHandler<Long, PatrolDTO, PatrolService> {

}