package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.OperationRecordDAO;
import com.powerbroker.resource.entity.OperationRecord;
import com.powerbroker.resource.model.OperationRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultOperationRecordService extends AbstractJPAService<Long, OperationRecordDTO, OperationRecord, OperationRecordDAO> implements OperationRecordService {

}
