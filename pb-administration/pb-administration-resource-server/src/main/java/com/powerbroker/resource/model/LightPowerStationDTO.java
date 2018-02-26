package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author william
 */
@Setter
@Getter
public class LightPowerStationDTO extends AbstractDTO {

    private String identifier;
    private String fakeIdentifier;
    private String customerNo;
    private String customerName;
    private String name;
    private String comment;
    private String responseArea;
    private String industryClass;
    private Integer voltage10;
    private Integer voltage35;
    private Integer voltage110;
    private Integer voltageUnknown;
    private String capacity;
    private String phone;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String longitude;
    private String latitude;
    private Integer state;
    private Integer type;
    private Boolean detection;
    private Boolean compensation;
    private Integer configurationCount;
    private List<PowerStationLineDTO> powerStationLines;

    public int getStationCount() {

        Integer stationCount = 0;

        if (null != voltage10) {
            stationCount += voltage10;
        }

        if (null != voltage35) {
            stationCount += voltage35;
        }
        if (null != voltage110) {
            stationCount += voltage110;
        }

        if (null != voltageUnknown) {
            stationCount += voltageUnknown;
        }

        return stationCount;
    }
}
