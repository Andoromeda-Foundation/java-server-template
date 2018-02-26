package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.DefectDTO;
import com.powerbroker.resource.service.DefectRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/defect")
public class DefectController extends AbstractCRUDHandler<Long, DefectDTO, DefectRecordService> {

}
