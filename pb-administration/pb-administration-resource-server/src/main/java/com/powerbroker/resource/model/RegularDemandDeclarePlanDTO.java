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
public class RegularDemandDeclarePlanDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;

    private Long distributionTransformerId;

    private LocalDate declareDate;

    private Long declareChangePeriod;

    private LightDeptDTO responsibleDepart;

    private String responsiblePosition;

    private Long responsibleAreaId;

    private String previousMonthDemand;

    private String previousYearDemand;

    private String previousMonthDispersion;

    private String previousYearDispersion;

    private String declareDemand;

    private String distributionTransformCapacity;

    private String distributionNo;
    private String dept;
    private String district;

}
