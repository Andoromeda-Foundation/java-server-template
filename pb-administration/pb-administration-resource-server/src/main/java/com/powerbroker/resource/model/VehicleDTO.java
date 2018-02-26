package com.powerbroker.resource.model;

import com.powerbroker.resource.model.gps.GpsDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class VehicleDTO extends LightVehicleDTO {

    private DocumentDTO document;
    private List<GpsDTO> gpses;
}
