package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerStationDeviceDAO;
import com.powerbroker.resource.entity.PowerStationDevice;
import com.powerbroker.resource.model.PowerStationDeviceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerStationDeviceService extends AbstractJPAService<Long, PowerStationDeviceDTO, PowerStationDevice, PowerStationDeviceDAO> implements PowerStationDeviceService {

}
