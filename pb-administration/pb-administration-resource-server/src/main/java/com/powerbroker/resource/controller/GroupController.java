package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.GroupDTO;
import com.powerbroker.resource.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/group")
public class GroupController extends AbstractCRUDHandler<Long, GroupDTO, GroupService> {

}
