package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.FaultRepositoryDAO;
import com.powerbroker.resource.entity.FaultRepository;
import com.powerbroker.resource.model.FaultRepositoryDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultFaultRepositoryService extends AbstractJPAService<Long, FaultRepositoryDTO, FaultRepository, FaultRepositoryDAO> implements FaultRepositoryService {

}
