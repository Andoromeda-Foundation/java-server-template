package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.AccidentDAO;
import com.powerbroker.resource.entity.Accident;
import com.powerbroker.resource.model.AccidentDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultAccidentService extends AbstractJPAService<Long, AccidentDTO, Accident, AccidentDAO> implements AccidentService {

}
