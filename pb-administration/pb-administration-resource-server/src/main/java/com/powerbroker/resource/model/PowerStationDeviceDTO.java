package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class PowerStationDeviceDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;
    private Long substationId;
    private String substationName;
    private String device;
    private String deviceCategory;
    private String deviceName;
    private String accountNumber;
    private String nameplateInfo;
    private String productionInfo;
    private String superiorDevice;
    private String provider;
    private String specification;
    private String quantity;
    private String factoryNumber;
    private String factoryDate;
    private String operationDate;
    private String comments;
    private String backup1;
    private String backup2;
}
