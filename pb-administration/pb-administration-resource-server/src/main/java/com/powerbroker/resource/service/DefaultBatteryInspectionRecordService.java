package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.BatteryInspectionRecordDAO;
import com.powerbroker.resource.entity.BatteryInspectionRecord;
import com.powerbroker.resource.model.BatteryInspectionRecordDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultBatteryInspectionRecordService extends AbstractJPAService<Long, BatteryInspectionRecordDTO, BatteryInspectionRecord, BatteryInspectionRecordDAO> implements BatteryInspectionRecordService {

}
