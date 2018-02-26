package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.IndexDTO;
import com.powerbroker.resource.service.IndexService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController extends AbstractCRUDHandler<Long, IndexDTO, IndexService> {

}
