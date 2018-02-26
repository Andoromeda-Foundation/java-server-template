package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.DispatchRecordDAO;
import com.powerbroker.resource.entity.DispatchRecord;
import com.powerbroker.resource.model.DispatchRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDispatchRecordService extends AbstractJPAService<Long, DispatchRecordDTO, DispatchRecord, DispatchRecordDAO> implements DispatchRecordService {

}
