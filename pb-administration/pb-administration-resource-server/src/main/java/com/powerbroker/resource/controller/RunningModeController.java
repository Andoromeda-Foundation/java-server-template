package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RunningModeDTO;
import com.powerbroker.resource.service.RunningModeService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/runningMode")
public class RunningModeController extends AbstractCRUDHandler<Long, RunningModeDTO, RunningModeService> {

}