package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.DeviceCategoryDAO;
import com.powerbroker.resource.entity.DeviceCategory;
import com.powerbroker.resource.model.DeviceCategoryDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDeviceCategoryService extends AbstractJPAService<Long, DeviceCategoryDTO, DeviceCategory, DeviceCategoryDAO> implements DeviceCategoryService {

}
