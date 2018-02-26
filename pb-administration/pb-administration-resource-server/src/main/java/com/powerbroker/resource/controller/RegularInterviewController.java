package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.RegularInterviewDTO;
import com.powerbroker.resource.service.RegularInterviewService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/regularInterview")
public class RegularInterviewController extends AbstractCRUDHandler<Long, RegularInterviewDTO, RegularInterviewService> {

}