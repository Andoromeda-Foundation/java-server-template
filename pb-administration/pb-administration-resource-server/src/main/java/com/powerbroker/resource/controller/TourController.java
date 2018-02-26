package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.TourDTO;
import com.powerbroker.resource.service.TourService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/tour")
public class TourController extends AbstractCRUDHandler<Long, TourDTO, TourService> {

}
