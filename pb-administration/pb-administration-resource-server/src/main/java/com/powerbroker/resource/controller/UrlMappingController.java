package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.UrlMappingDTO;
import com.powerbroker.resource.service.UrlMappingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/urlMapping")
public class UrlMappingController extends AbstractCRUDHandler<Long, UrlMappingDTO, UrlMappingService> {

}
