package com.powerbroker.resource.service;

import com.powerbroker.common.exception.AppException;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.dao.DelegationDAO;
import com.powerbroker.resource.entity.Client;
import com.powerbroker.resource.entity.Delegation;
import com.powerbroker.resource.model.DelegationDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultClientDelegationService extends AbstractJPAService<Long, DelegationDTO, Delegation, DelegationDAO> implements DelegationService {

    @Resource
    private ClientDAO clientDAO;

    @Override
    protected void createHandler(Delegation target) {

        Long clientId = getCurrentAuthUserId();

        Client client = clientDAO.getOne(clientId);
        target.setClient(client);
        target.setPowerStation(client.getPowerStation());
        target.setState(DELEGATION_STATE_WAITING);

        super.createHandler(target);
    }

    @Override
    public boolean approve(Long id) {
        throw new AppException("client not support approve");
    }

    @Override
    public boolean reject(Long id) {
        throw new AppException("client not support reject");
    }
}
