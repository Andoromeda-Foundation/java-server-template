package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.DefectRecordDAO;
import com.powerbroker.resource.entity.Defect;
import com.powerbroker.resource.model.DefectDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDefectRecordService extends AbstractJPAService<Long, DefectDTO, Defect, DefectRecordDAO> implements DefectRecordService {

    @Override
    protected void createHandler(Defect target) {
        super.createHandler(target);

        target.getReward().setHasData(true);
    }
}
