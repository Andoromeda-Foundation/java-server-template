package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.IndexMappingDTO;
import com.powerbroker.resource.service.IndexMappingService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/indexMapping")
public class IndexMappingController extends AbstractCRUDHandler<Long, IndexMappingDTO, IndexMappingService> {

}
