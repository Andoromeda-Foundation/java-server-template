package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.UsageDTO;
import com.powerbroker.resource.service.UsageService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/usage")
public class UsageController extends AbstractCRUDHandler<Long, UsageDTO, UsageService> {

}
