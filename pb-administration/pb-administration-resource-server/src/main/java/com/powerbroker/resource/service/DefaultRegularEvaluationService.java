package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.RegularEvaluationDAO;
import com.powerbroker.resource.entity.RegularEvaluation;
import com.powerbroker.resource.model.RegularEvaluationDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultRegularEvaluationService extends AbstractJPAService<Long, RegularEvaluationDTO, RegularEvaluation, RegularEvaluationDAO> implements RegularEvaluationService {

}
