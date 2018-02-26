package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.PowerConsumeDAO;
import com.powerbroker.resource.entity.PowerConsume;
import com.powerbroker.resource.model.PowerConsumeDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerConsumeService extends AbstractJPAService<Long, PowerConsumeDTO, PowerConsume, PowerConsumeDAO> implements PowerConsumeService {

}
