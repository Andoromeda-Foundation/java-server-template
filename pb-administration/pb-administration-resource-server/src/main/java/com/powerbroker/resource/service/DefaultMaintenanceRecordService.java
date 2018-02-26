package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.MaintenanceRecordDAO;
import com.powerbroker.resource.entity.MaintenanceRecord;
import com.powerbroker.resource.model.MaintenanceRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultMaintenanceRecordService extends AbstractJPAService<Long, MaintenanceRecordDTO, MaintenanceRecord, MaintenanceRecordDAO> implements MaintenanceRecordService {

}
