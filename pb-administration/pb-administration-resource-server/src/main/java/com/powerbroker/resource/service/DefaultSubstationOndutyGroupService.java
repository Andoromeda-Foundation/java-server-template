package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.SubstationOndutyGroupDAO;
import com.powerbroker.resource.entity.SubstationOndutyGroup;
import com.powerbroker.resource.model.SubstationOndutyGroupDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultSubstationOndutyGroupService extends AbstractJPAService<Long, SubstationOndutyGroupDTO, SubstationOndutyGroup, SubstationOndutyGroupDAO> implements SubstationOndutyGroupService {

}
