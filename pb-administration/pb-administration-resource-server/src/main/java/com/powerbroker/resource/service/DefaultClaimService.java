package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ClaimDAO;
import com.powerbroker.resource.entity.Claim;
import com.powerbroker.resource.model.ClaimDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultClaimService extends AbstractJPAService<Long, ClaimDTO, Claim, ClaimDAO> implements ClaimService {

}
