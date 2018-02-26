package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.MeasureReadDTO;
import com.powerbroker.resource.service.MeasureReadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/measureRead")
public class MeasureReadController extends AbstractCRUDHandler<Long, MeasureReadDTO, MeasureReadService> {

}
