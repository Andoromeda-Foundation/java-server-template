package com.powerbroker.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.RewardPatrolDTO;
import com.powerbroker.resource.service.RewardPatrolService;

/**
 * @author wjwjtftf
 */
@RestController
@RequestMapping(value = "/rewardPatrol")
public class RewardPatrolController extends AbstractCRUDHandler<Long, RewardPatrolDTO, RewardPatrolService> {

}
