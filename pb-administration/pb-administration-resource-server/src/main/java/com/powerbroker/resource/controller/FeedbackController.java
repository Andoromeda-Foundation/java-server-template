package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.FeedbackDTO;
import com.powerbroker.resource.service.FeedbackService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController extends AbstractCRUDHandler<Long, FeedbackDTO, FeedbackService> {

}
