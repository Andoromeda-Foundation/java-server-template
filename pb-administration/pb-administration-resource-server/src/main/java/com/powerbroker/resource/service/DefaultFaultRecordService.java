package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.FaultRecordDAO;
import com.powerbroker.resource.entity.FaultRecord;
import com.powerbroker.resource.model.FaultRecordDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultFaultRecordService extends AbstractJPAService<Long, FaultRecordDTO, FaultRecord, FaultRecordDAO> implements FaultRecordService {

    @Override
    protected void createHandler(FaultRecord target) {
        if (target.getReward().getTaskState() != TaskService.TASK_STATE_EXECUTED) {
            throw new IllegalStateException("task state not been executed.");
        }
    }
}
