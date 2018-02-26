package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.RepairDAO;
import com.powerbroker.resource.entity.Repair;
import com.powerbroker.resource.model.RepairDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRepairService extends AbstractJPAService<Long, RepairDTO, Repair, RepairDAO> implements RepairService {

}
