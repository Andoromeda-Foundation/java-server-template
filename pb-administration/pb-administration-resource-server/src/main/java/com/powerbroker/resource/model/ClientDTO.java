package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
public class ClientDTO extends LightClientDTO {

    @Setter
    @Getter
    private LightPowerStationDTO powerStation;
}
