package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DistrictDTO;
import com.powerbroker.resource.service.DistrictService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/district")
public class DistrictController extends AbstractCRUDHandler<Long, DistrictDTO, DistrictService> {

}
