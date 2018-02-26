package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.WarningLogDAO;
import com.powerbroker.resource.entity.WarningLog;
import com.powerbroker.resource.model.WarningLogDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultWarningLogService extends AbstractJPAService<Long, WarningLogDTO, WarningLog, WarningLogDAO> implements WarningLogService {

}
