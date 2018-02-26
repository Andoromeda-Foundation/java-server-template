package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ElectricParameterDAO;
import com.powerbroker.resource.entity.ElectricParameter;
import com.powerbroker.resource.model.ElectricParameterDTO;
import com.powerbroker.common.service.AbstractJPAService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultElectricParameterService extends AbstractJPAService<Long, ElectricParameterDTO, ElectricParameter, ElectricParameterDAO> implements ElectricParameterService {

}
