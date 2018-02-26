package com.powerbroker.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.RewardPatrolDAO;
import com.powerbroker.resource.entity.RewardPatrol;
import com.powerbroker.resource.model.RewardPatrolDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wjwjtftf
 *         Created on 2017/1/18.
 */
@Service
@Transactional
@Slf4j
public class DefaultRewardPatrolService extends AbstractJPAService<Long, RewardPatrolDTO, RewardPatrol, RewardPatrolDAO>
		implements RewardPatrolService {
}
