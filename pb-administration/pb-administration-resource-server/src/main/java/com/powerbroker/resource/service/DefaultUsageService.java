package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.UsageDAO;
import com.powerbroker.resource.entity.Usage;
import com.powerbroker.resource.model.UsageDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultUsageService extends AbstractJPAService<Long, UsageDTO, Usage, UsageDAO> implements UsageService {

}
