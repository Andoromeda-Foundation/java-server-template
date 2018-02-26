package com.powerbroker.resource.service;

import com.powerbroker.common.service.CRUDService;
import com.powerbroker.resource.model.gps.AccountDTO;
import com.powerbroker.resource.model.gps.AuthDTO;
import com.powerbroker.resource.model.gps.GpsDTO;
import com.powerbroker.resource.model.gps.TrackingDTO;

/**
 * @author william
 */
public interface GpsApiService extends CRUDService<Long, TrackingDTO> {

    TrackingDTO tracking(GpsDTO gps);

    AuthDTO refreshToken(AccountDTO accountDTO);
}
