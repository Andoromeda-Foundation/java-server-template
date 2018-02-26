package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DeviceCategoryDTO;
import com.powerbroker.resource.service.DeviceCategoryService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/deviceCategory")
public class DeviceCategoryController extends AbstractCRUDHandler<Long, DeviceCategoryDTO, DeviceCategoryService> {

}