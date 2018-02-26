package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author william
 */
@Setter
@Getter
public class DeviceDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;
    private String deviceGenere;
    private String deviceCategory;
    private String deviceName;
    private String accountNumber;
    private String nameplateInfo;
    private String superiorDevice;
    private String provider;
    private String specification;
    private String productionInfo;
    private String quantity;
    private String factoryNumber;
    private LocalDate factoryDate;
    private LocalDate operationDate;
    private String comment;
    private String backup1;
    private String backup2;
}
