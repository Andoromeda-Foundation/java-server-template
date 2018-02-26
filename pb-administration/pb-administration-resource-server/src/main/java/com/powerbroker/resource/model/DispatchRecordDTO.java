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
public class DispatchRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String inspectionItems;
    private String inspectionStandards;
    private String inspectionConfirmation;
    private String inspectionMan;
    private LocalDate inspectionDate;
    private String inspectionSituation;
    private String conclusion;

    private LightPowerStationDTO powerStation;
    private String content;
    private String state;
    private String deviceCount;
    private String executionRate;
    private String finishRate;
    private String tourUnit;
    private String defect;
    private String extinctDefect;
    private String pastLock;
}
