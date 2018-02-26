package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.{{Target}}DTO;
import com.powerbroker.resource.service.{{Target}}Service;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/{{TargetPath}}")
public class {{Target}}Controller extends AbstractCRUDHandler<Long, {{Target}}DTO, {{Target}}Service> {

}