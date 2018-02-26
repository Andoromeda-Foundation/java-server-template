package com.powerbroker.resource.service;

import com.powerbroker.common.service.PageableService;
import com.powerbroker.resource.model.PowerStationDTO;

/**
 * @author william
 */
public interface PowerStationService extends PageableService<Long, PowerStationDTO> {

    int POWER_STATION_OFFLINE = 0;
    int POWER_STATION_ONLINE = 1;
}
