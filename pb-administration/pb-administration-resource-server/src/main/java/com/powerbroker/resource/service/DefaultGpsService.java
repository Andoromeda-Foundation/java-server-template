package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.resource.dao.GpsDAO;
import com.powerbroker.resource.entity.Gps;
import com.powerbroker.resource.model.gps.AuthDTO;
import com.powerbroker.resource.model.gps.GpsDTO;
import com.powerbroker.resource.model.gps.TrackingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author william
 */
@Slf4j
@Service
@Transactional
public class DefaultGpsService extends AbstractJPAService<Long, GpsDTO, Gps, GpsDAO> implements GpsService {

    @Resource
    private GpsApiService gpsApiService;

    @Override
    @Transactional
    public GpsDTO retrieve(Long id) {

        GpsDTO gpsdto = super.retrieve(id);

        if (!gpsdto.isValid()) {
            AuthDTO authDTO = gpsApiService.refreshToken(gpsdto.getAccount());

            gpsdto.setAccessToken(authDTO.getAccess_token());
            gpsdto.setExpiresIn(authDTO.getExpires_in());
            gpsdto.setExpiresDate(new Date(System.currentTimeMillis() + 7200L * 1000));

            update(gpsdto);
        }

        TrackingDTO tracking = gpsApiService.tracking(gpsdto);
        gpsdto.setTracking(tracking);

        return gpsdto;
    }
}
