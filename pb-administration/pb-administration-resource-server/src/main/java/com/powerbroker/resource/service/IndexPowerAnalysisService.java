package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexPowerAnalysisDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexPowerAnalysisService extends IndexItemService<String, IndexPowerAnalysisDTO> {

    List<IndexPowerAnalysisDTO> historyByDay(IndexPowerAnalysisDTO condition) throws ParseException;
}
