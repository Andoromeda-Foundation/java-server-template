package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.RunningModeDAO;
import com.powerbroker.resource.entity.RunningMode;
import com.powerbroker.resource.model.RunningModeDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRunningModeService extends AbstractJPAService<Long, RunningModeDTO, RunningMode, RunningModeDAO> implements RunningModeService {

}
