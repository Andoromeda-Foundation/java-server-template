package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ProtectionDeviceWorkingRecordDAO;
import com.powerbroker.resource.entity.ProtectionDeviceWorkingRecord;
import com.powerbroker.resource.model.ProtectionDeviceWorkingRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultProtectionDeviceWorkingRecordService extends AbstractJPAService<Long, ProtectionDeviceWorkingRecordDTO, ProtectionDeviceWorkingRecord, ProtectionDeviceWorkingRecordDAO> implements ProtectionDeviceWorkingRecordService {

}
