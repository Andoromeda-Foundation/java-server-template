package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.HierarchyDTO;
import com.powerbroker.resource.service.HierarchyService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/hierarchy")
public class HierarchyController extends AbstractCRUDHandler<Long, HierarchyDTO, HierarchyService> {

}
