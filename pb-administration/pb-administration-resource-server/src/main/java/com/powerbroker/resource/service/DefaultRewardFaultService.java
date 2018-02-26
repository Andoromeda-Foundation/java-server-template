package com.powerbroker.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.RewardFaultDAO;
import com.powerbroker.resource.entity.RewardFault;
import com.powerbroker.resource.model.RewardFaultDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wjwjtftf
 *         Created on 2017/1/18.
 */
@Service
@Transactional
@Slf4j
public class DefaultRewardFaultService extends AbstractJPAService<Long, RewardFaultDTO, RewardFault, RewardFaultDAO>
		implements RewardFaultService {
}
