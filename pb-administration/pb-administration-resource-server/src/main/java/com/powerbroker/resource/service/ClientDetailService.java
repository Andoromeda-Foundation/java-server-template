package com.powerbroker.resource.service;

import com.powerbroker.resource.model.ClientDetailDTO;
import com.powerbroker.common.service.PageableService;

/**
 * @author william
 */
public interface ClientDetailService extends PageableService<Long, ClientDetailDTO> {

    ClientDetailDTO resetSecret(ClientDetailDTO dto);
}
