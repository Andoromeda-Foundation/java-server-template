package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.ContractDAO;
import com.powerbroker.resource.entity.Contract;
import com.powerbroker.resource.model.ContractDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultContractService extends AbstractJPAService<Long, ContractDTO, Contract, ContractDAO>
        implements ContractService {
}
