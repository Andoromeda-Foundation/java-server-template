package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RegularMeetingPlanDTO;
import com.powerbroker.resource.service.RegularMeetingPlanService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/regularMeetingPlan")
public class RegularMeetingPlanController extends AbstractCRUDHandler<Long, RegularMeetingPlanDTO, RegularMeetingPlanService> {

}