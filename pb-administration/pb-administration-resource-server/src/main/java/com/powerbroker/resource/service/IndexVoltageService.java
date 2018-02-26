package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexVoltageDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexVoltageService extends IndexItemService<String, IndexVoltageDTO> {

    List<IndexVoltageDTO> historyMaxByDay(IndexVoltageDTO condition) throws ParseException;

    List<IndexVoltageDTO> historyMinByDay(IndexVoltageDTO condition) throws ParseException;
}
