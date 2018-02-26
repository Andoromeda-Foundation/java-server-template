package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.VehicleDAO;
import com.powerbroker.resource.entity.Vehicle;
import com.powerbroker.resource.model.VehicleDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultVehicleService extends AbstractJPAService<Long, VehicleDTO, Vehicle, VehicleDAO> implements VehicleService {

}
