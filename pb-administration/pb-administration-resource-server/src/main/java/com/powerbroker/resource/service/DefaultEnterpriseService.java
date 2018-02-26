package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.EnterpriseDAO;
import com.powerbroker.resource.entity.Enterprise;
import com.powerbroker.resource.model.EnterpriseDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultEnterpriseService extends AbstractJPAService<Long, EnterpriseDTO, Enterprise, EnterpriseDAO> implements EnterpriseService {

}
