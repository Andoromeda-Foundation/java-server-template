package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.NavDTO;
import com.powerbroker.resource.service.NavService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/nav")
public class NavController extends AbstractCRUDHandler<Long, NavDTO, NavService> {

}