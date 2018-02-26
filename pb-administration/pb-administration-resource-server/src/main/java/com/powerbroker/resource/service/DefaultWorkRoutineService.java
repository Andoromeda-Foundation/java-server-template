package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.WorkRoutineDAO;
import com.powerbroker.resource.entity.WorkRoutine;
import com.powerbroker.resource.model.WorkRoutineDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultWorkRoutineService extends AbstractJPAService<Long, WorkRoutineDTO, WorkRoutine, WorkRoutineDAO> implements WorkRoutineService {

}
