package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class RfidDTO extends AbstractDTO {

    private String identifier;

    private String deviceName;

    private String deviceType;

    private String responsible;

    private LightPowerStationDTO powerStation;

    private PowerStationLineDTO powerStationLine;
}
