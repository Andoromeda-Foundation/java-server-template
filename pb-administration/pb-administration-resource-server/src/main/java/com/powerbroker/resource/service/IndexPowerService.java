package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexPowerDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexPowerService extends IndexItemService<String, IndexPowerDTO> {

    List<IndexPowerDTO> historyByDay(IndexPowerDTO condition) throws ParseException;
}
