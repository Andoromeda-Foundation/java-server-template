package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerGridDeviceDAO;
import com.powerbroker.resource.entity.PowerGridDevice;
import com.powerbroker.resource.model.PowerGridDeviceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerGridDeviceService extends AbstractJPAService<Long, PowerGridDeviceDTO, PowerGridDevice, PowerGridDeviceDAO> implements PowerGridDeviceService {

}
