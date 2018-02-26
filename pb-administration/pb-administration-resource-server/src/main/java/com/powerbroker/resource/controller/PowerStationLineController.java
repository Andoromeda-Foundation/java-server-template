package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.PowerStationLineDTO;
import com.powerbroker.resource.service.PowerStationLineService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/powerStationLine")
public class PowerStationLineController extends AbstractCRUDHandler<Long, PowerStationLineDTO, PowerStationLineService> {

}
