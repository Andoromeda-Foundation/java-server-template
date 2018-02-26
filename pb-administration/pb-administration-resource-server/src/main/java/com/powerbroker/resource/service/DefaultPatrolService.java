package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PatrolDAO;
import com.powerbroker.resource.entity.Patrol;
import com.powerbroker.resource.model.PatrolDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPatrolService extends AbstractJPAService<Long, PatrolDTO, Patrol, PatrolDAO> implements PatrolService {

}
