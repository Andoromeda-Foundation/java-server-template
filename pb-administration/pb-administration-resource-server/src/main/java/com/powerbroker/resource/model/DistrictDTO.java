package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class DistrictDTO extends LightDistrictDTO {

    private List<LightPowerStationDTO> powerStations = new ArrayList<>();
}
