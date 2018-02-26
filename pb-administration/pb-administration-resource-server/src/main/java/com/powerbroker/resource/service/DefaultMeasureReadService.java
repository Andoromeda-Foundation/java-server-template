package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.MeasureReadDAO;
import com.powerbroker.resource.entity.MeasureRead;
import com.powerbroker.resource.model.MeasureReadDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultMeasureReadService extends AbstractJPAService<Long, MeasureReadDTO, MeasureRead, MeasureReadDAO> implements MeasureReadService {

    @Override
    protected void createHandler(MeasureRead target) {
        if (target.getReward().getTaskState() != TaskService.TASK_STATE_EXECUTED) {
            throw new IllegalStateException("task state not been executed.");
        }
    }
}
