package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.MaintenanceServiceDAO;
import com.powerbroker.resource.entity.MaintenanceService;
import com.powerbroker.resource.model.MaintenanceServiceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultMaintenanceServiceService extends AbstractJPAService<Long, MaintenanceServiceDTO, MaintenanceService, MaintenanceServiceDAO> implements MaintenanceServiceService {

}
