package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.RegularInterviewDAO;
import com.powerbroker.resource.entity.RegularInterview;
import com.powerbroker.resource.model.RegularInterviewDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRegularInterviewService extends AbstractJPAService<Long, RegularInterviewDTO, RegularInterview, RegularInterviewDAO> implements RegularInterviewService {

}
