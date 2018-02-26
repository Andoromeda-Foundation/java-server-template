package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.MetricFilterMappingDTO;
import com.powerbroker.resource.service.MetricFilterMappingService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/metricFilterMapping")
public class MetricFilterMappingController extends AbstractCRUDHandler<Long, MetricFilterMappingDTO, MetricFilterMappingService> {

}
