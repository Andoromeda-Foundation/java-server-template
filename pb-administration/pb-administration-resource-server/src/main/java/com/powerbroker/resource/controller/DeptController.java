package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DeptDTO;
import com.powerbroker.resource.service.DeptService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController extends AbstractCRUDHandler<Long, DeptDTO, DeptService> {

}
