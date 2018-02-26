package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.InsuranceDAO;
import com.powerbroker.resource.entity.Insurance;
import com.powerbroker.resource.model.InsuranceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultInsuranceService extends AbstractJPAService<Long, InsuranceDTO, Insurance, InsuranceDAO> implements InsuranceService {

}
