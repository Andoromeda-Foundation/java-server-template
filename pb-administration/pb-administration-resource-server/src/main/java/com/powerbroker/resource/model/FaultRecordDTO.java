package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class FaultRecordDTO extends AbstractDTO {


    private String customerName;
    private String stationName;
    private String faultDevice;
    private String appearance;
    private LocalDateTime repairDate;
    private String repairDuration;
    private LocalDateTime recoveryDate;
    private String dutyEmployee;
    private LocalDateTime arriveDate;
    private LocalDateTime isolationDate;
    private String repairEmployee;
    private String area;
    private String technologyReason;
    private String deviceReason;
    private String desc;
    private Integer type;
    private Integer priority;
    private LightRewardDTO reward;
    private LightPowerStationDTO powerStation;
    private PowerStationLineDTO powerStationLine;
}
