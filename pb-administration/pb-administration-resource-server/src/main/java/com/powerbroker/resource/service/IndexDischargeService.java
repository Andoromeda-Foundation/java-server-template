package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexDischargeDTO;

import java.util.List;
import java.util.Set;

/**
 * @author william
 */
public interface IndexDischargeService extends IndexItemService<String, IndexDischargeDTO> {

    List<IndexDischargeDTO> realTimeHistory(IndexDischargeDTO condition);

    Set<Object> deviceList(IndexDischargeDTO condition);
}
