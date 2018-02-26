package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.EventLogDAO;
import com.powerbroker.resource.entity.EventLog;
import com.powerbroker.resource.model.EventLogDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultEventLogService extends AbstractJPAService<Long, EventLogDTO, EventLog, EventLogDAO> implements EventLogService {

}
