package com.powerbroker.resource.service;

import com.powerbroker.resource.model.UrlMappingDTO;
import com.powerbroker.common.service.PageableService;

/**
 * @author william
 */
public interface UrlMappingService extends PageableService<Long, UrlMappingDTO> {

    UrlMappingDTO mergeUrl(UrlMappingDTO dto);
}
