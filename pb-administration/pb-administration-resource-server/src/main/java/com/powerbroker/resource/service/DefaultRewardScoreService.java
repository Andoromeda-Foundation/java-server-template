package com.powerbroker.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.RewardScoreDAO;
import com.powerbroker.resource.entity.RewardScore;
import com.powerbroker.resource.model.RewardScoreDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wjwjtftf
 *         Created on 2017/1/18.
 */
@Service
@Transactional
@Slf4j
public class DefaultRewardScoreService extends AbstractJPAService<Long, RewardScoreDTO, RewardScore, RewardScoreDAO>
		implements RewardScoreService {
}
