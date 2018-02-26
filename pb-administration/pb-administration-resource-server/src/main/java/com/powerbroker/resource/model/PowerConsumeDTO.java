package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class PowerConsumeDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;
    private String address;
    private LightDistrictDTO district;
    private String distributionNo;
    private BigDecimal peak;
    private BigDecimal plain;
    private BigDecimal valley;
    private BigDecimal factor;
    private Integer month;

    private Long customerId;
    private String mainBusiness;
    private String secBusiness1;
    private String secBusiness2;
    private String secBusiness3;
    private String secBusiness4;
    private String secBusiness5;
    private String secBusiness6;
    private String secBusiness7;
    private String secBusiness8;
    private String secBusiness9;
    private String secBusiness10;
    private String secBusinessSummary;
    private LocalDateTime summaryTime;
    private String allBusiness;
    private String mainBusinessCost;
    private String secBusinessCost1;
    private String secBusinessCost2;
    private String secBusinessCost3;
    private String secBusinessCost4;
    private String secBusinessCost5;
    private String secBusinessCost6;
    private String secBusinessCost7;
    private String secBusinessCost8;
    private String secBusinessCost9;
    private String secBusinessCost10;
    private String secBusinessCostSummary;
    private LocalDateTime costSummaryTime;
    private String demand1;
    private String demand2;
    private String demand3;
    private String demand4;
}
