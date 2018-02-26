package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class IndexMappingDTO extends AbstractDTO {

    private String name;
    private String indexIdentifier;
    private String stationIdentifier;
    private String lineIdentifier;
    private String node;
    private String keys;
    private Integer type;
    private IndexDTO index;

    private LightPowerStationDTO station;
    private PowerStationLineDTO line;
}
