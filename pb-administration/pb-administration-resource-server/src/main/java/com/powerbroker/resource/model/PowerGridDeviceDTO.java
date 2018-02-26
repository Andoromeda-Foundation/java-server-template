package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class PowerGridDeviceDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;
    private String substationName;
    private String device;
    private String deviceCategory;
    private String deviceName;
    private String accountNumber;
    private String nameplateInfo;
    private String productionInfo;
    private String specification;
    private String quantity;
    private String factoryNumber;
    private LocalDateTime factoryDate;
    private LocalDateTime operationDate;
    private String comments;
    private String backup1;
    private String backup2;
}
