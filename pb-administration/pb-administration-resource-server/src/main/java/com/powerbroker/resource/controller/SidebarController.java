package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.SidebarDTO;
import com.powerbroker.resource.service.SidebarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/sidebar")
public class SidebarController extends AbstractCRUDHandler<Long, SidebarDTO, SidebarService> {

}
