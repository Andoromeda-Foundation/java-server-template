package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerProduceDeviceDAO;
import com.powerbroker.resource.entity.PowerProduceDevice;
import com.powerbroker.resource.model.PowerProduceDeviceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerProduceDeviceService extends AbstractJPAService<Long, PowerProduceDeviceDTO, PowerProduceDevice, PowerProduceDeviceDAO> implements PowerProduceDeviceService {

}
