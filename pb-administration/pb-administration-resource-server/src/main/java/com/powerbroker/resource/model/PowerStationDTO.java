package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class PowerStationDTO extends LightPowerStationDTO {

    private MdRequestDTO mdRequest;

    private List<LightDistrictDTO> districts;
}
