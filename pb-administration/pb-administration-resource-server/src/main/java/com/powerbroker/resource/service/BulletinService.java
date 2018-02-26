package com.powerbroker.resource.service;

import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.BulletinDTO;
import com.powerbroker.resource.model.BulletinStateDTO;

/**
 * @author william
 */
public interface BulletinService extends PageableService<Long, BulletinDTO> {

    void read(Long id);
    BulletinStateDTO state();
}
