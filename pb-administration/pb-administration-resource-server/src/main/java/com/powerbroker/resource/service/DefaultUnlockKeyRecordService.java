package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.UnlockKeyRecordDAO;
import com.powerbroker.resource.entity.UnlockKeyRecord;
import com.powerbroker.resource.model.UnlockKeyRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultUnlockKeyRecordService extends AbstractJPAService<Long, UnlockKeyRecordDTO, UnlockKeyRecord, UnlockKeyRecordDAO> implements UnlockKeyRecordService {

}
