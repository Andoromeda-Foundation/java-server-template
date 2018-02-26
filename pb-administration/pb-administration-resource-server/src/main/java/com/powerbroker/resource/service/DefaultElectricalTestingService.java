package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.ElectricalTestingDAO;
import com.powerbroker.resource.entity.ElectricalTesting;
import com.powerbroker.resource.model.ElectricalTestingDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultElectricalTestingService extends AbstractJPAService<Long, ElectricalTestingDTO, ElectricalTesting, ElectricalTestingDAO> implements ElectricalTestingService {

}
