package com.powerbroker.resource.service;

import com.powerbroker.resource.dao.FeedbackDAO;
import com.powerbroker.resource.entity.Feedback;
import com.powerbroker.resource.model.FeedbackDTO;
import com.powerbroker.common.service.AbstractJPAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultFeedbackService extends AbstractJPAService<Long, FeedbackDTO, Feedback, FeedbackDAO> implements FeedbackService {

}
