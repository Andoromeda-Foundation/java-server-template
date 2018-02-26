package com.powerbroker.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.RewardScoreDTO;
import com.powerbroker.resource.service.RewardScoreService;

/**
 * @author wjwjtftf
 */
@RestController
@RequestMapping(value = "/rewardScore")
public class RewardScoreController extends AbstractCRUDHandler<Long, RewardScoreDTO, RewardScoreService> {

}
