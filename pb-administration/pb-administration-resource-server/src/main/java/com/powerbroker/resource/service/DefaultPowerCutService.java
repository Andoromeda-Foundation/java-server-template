package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerCutDAO;
import com.powerbroker.resource.entity.PowerCut;
import com.powerbroker.resource.model.PowerCutDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerCutService extends AbstractJPAService<Long, PowerCutDTO, PowerCut, PowerCutDAO> implements PowerCutService {

}
