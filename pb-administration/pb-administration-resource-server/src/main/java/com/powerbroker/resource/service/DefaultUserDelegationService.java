package com.powerbroker.resource.service;

import com.powerbroker.common.exception.AppException;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.dao.DelegationDAO;
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
public class DefaultUserDelegationService extends AbstractJPAService<Long, DelegationDTO, Delegation, DelegationDAO> implements DelegationService {

    @Resource
    private ClientDAO clientDAO;

    @Override
    public DelegationDTO create(DelegationDTO dto) {
        throw new AppException("user not support create");
    }

    @Override
    public boolean approve(Long id) {
        DelegationDTO delegation = retrieve(id);

        if (null != delegation) {
            delegation.setState(DELEGATION_STATE_APPROVED);
            update(delegation);
        }

        return true;
    }

    @Override
    public boolean reject(Long id) {
        DelegationDTO delegation = retrieve(id);

        if (null != delegation) {
            delegation.setState(DELEGATION_STATE_REJECTED);
            update(delegation);
        }

        return true;
    }
}
