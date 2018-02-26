package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.InspectionDAO;
import com.powerbroker.resource.entity.Inspection;
import com.powerbroker.resource.model.InspectionDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultInspectionService extends AbstractJPAService<Long, InspectionDTO, Inspection, InspectionDAO> implements InspectionService {

}
