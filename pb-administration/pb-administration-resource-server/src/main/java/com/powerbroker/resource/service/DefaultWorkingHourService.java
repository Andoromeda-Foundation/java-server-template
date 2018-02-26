package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.WorkingHourDAO;
import com.powerbroker.resource.entity.WorkingHour;
import com.powerbroker.resource.model.WorkingHourDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultWorkingHourService extends AbstractJPAService<Long, WorkingHourDTO, WorkingHour, WorkingHourDAO> implements WorkingHourService {

}
