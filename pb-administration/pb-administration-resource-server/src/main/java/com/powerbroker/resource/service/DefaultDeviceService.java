package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.DeviceDAO;
import com.powerbroker.resource.entity.Device;
import com.powerbroker.resource.model.DeviceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDeviceService extends AbstractJPAService<Long, DeviceDTO, Device, DeviceDAO> implements DeviceService {

}
