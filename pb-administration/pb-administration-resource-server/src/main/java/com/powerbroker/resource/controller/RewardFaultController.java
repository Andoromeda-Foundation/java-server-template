package com.powerbroker.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.RewardFaultDTO;
import com.powerbroker.resource.service.RewardFaultService;

/**
 * @author wjwjtftf
 */
@RestController
@RequestMapping(value = "/rewardFault")
public class RewardFaultController extends AbstractCRUDHandler<Long, RewardFaultDTO, RewardFaultService> {

}
