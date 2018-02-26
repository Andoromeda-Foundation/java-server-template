package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.StaffDTO;
import com.powerbroker.resource.service.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/staff")
public class StaffController extends AbstractCRUDHandler<Long, StaffDTO, StaffService> {

}
