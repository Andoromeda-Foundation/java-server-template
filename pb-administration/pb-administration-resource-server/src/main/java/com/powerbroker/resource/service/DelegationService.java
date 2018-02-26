package com.powerbroker.resource.service;

import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.DelegationDTO;

/**
 * @author william
 */
public interface DelegationService extends PageableService<Long, DelegationDTO> {

    int DELEGATION_STATE_WAITING = 1;
    int DELEGATION_STATE_APPROVED = 2;
    int DELEGATION_STATE_REJECTED = 3;

    boolean approve(Long id);

    boolean reject(Long id);
}