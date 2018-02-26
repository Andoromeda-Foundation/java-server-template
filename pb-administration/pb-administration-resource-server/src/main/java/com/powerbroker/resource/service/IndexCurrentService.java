package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexCurrentDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
public interface IndexCurrentService extends IndexItemService<String, IndexCurrentDTO> {

    List<IndexCurrentDTO> historyMaxByDay(IndexCurrentDTO condition) throws ParseException;

    List<IndexCurrentDTO> historyMinByDay(IndexCurrentDTO condition) throws ParseException;
}
