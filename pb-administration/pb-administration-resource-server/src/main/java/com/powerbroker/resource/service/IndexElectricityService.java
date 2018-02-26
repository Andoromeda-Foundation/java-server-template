package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexElectricityDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexElectricityService extends IndexItemService<String, IndexElectricityDTO> {

    List<IndexElectricityDTO> historyByMonth(IndexElectricityDTO condition) throws ParseException;
}
