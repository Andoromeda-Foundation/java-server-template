package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RegularEvaluationDTO;
import com.powerbroker.resource.service.RegularEvaluationService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/regularEvaluation")
public class RegularEvaluationController extends AbstractCRUDHandler<Long, RegularEvaluationDTO, RegularEvaluationService> {

}