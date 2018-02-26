package com.powerbroker.resource.controller;

import com.powerbroker.resource.model.ArresterActionRecordDTO;
import com.powerbroker.resource.service.ArresterActionRecordService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/arresterActionRecord")
public class ArresterActionRecordController extends AbstractCRUDHandler<Long, ArresterActionRecordDTO, ArresterActionRecordService> {

}
