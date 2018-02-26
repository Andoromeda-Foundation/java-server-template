package com.powerbroker.resource.service;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.ClientDAO;
import com.powerbroker.resource.dao.DelegationDAO;
import com.powerbroker.resource.entity.Delegation;
import com.powerbroker.resource.model.DelegationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDelegationService extends AbstractJPAService<Long, DelegationDTO, Delegation, DelegationDAO> implements DelegationService {

    @Resource(name = "defaultClientDelegationService")
    private DelegationService defaultClientDelegationService;

    @Resource(name = "defaultUserDelegationService")
    private DelegationService defaultUserDelegationService;

    @Resource
    private ClientDAO clientDAO;

    private DelegationService getProxyService() {

        PBAuthUser authUser = getCurrentAuthUser();

        if (authUser.getType() == 1) {
            return defaultUserDelegationService;
        } else if (authUser.getType() == 2) {
            return defaultClientDelegationService;
        }

        return this;
    }

    @Override
    public DelegationDTO create(DelegationDTO dto) {
        return getProxyService().create(dto);
    }

    @Override
    public boolean update(DelegationDTO dto) {
        return getProxyService().update(dto);
    }

    @Override
    public DelegationDTO retrieve(Long id) {
        return getProxyService().retrieve(id);
    }

    @Override
    public boolean delete(Long id) {
        return getProxyService().delete(id);
    }

    @Override
    @Transactional
    public boolean active(Long id) {
        return getProxyService().active(id);
    }

    @Override
    @Transactional
    public boolean deactive(Long id) {
        return getProxyService().deactive(id);
    }

    @Override
    public Page<DelegationDTO> list(DelegationDTO condition, Pageable pageable) {
        return getProxyService().list(condition, pageable);
    }

    @Override
    public Page<DelegationDTO> listAll(Pageable pageable) {
        return super.listAll(pageable);
    }

    @Override
    public List<DelegationDTO> listAllActive() {
        return getProxyService().listAllActive();
    }

    @Override
    public Page<DelegationDTO> listActive(Pageable pageable) {
        return getProxyService().listActive(pageable);
    }

    @Override
    public boolean approve(Long id) {
        return getProxyService().approve(id);
    }

    @Override
    public boolean reject(Long id) {
        return getProxyService().reject(id);
    }
}
