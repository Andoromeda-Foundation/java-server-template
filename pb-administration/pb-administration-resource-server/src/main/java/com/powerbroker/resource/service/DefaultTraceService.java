package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.TraceDAO;
import com.powerbroker.resource.entity.Trace;
import com.powerbroker.resource.model.TraceDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultTraceService extends AbstractJPAService<Long, TraceDTO, Trace, TraceDAO> implements TraceService {

}
