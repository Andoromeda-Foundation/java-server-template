package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerConsumeDeviceDAO;
import com.powerbroker.resource.entity.PowerConsumeDevice;
import com.powerbroker.resource.model.PowerConsumeDeviceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerConsumeDeviceService extends AbstractJPAService<Long, PowerConsumeDeviceDTO, PowerConsumeDevice, PowerConsumeDeviceDAO> implements PowerConsumeDeviceService {

}
