package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.NonRunningRecordDAO;
import com.powerbroker.resource.entity.NonRunningRecord;
import com.powerbroker.resource.model.NonRunningRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultNonRunningRecordService extends AbstractJPAService<Long, NonRunningRecordDTO, NonRunningRecord, NonRunningRecordDAO> implements NonRunningRecordService {

}
