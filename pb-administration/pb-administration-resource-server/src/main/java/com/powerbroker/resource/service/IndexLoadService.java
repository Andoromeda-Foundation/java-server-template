package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.resource.model.IndexLoadDTO;

import java.util.List;

/**
 * @author william
 */
public interface IndexLoadService extends IndexItemService<String, IndexLoadDTO> {

    List<IndexLoadDTO> realTimeHistory(IndexLoadDTO condition);
}
