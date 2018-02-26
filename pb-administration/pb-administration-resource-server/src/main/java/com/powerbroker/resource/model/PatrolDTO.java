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
public class PatrolDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;

    private LightDeptDTO dutyDepart;

    private String deviceCategory;
    private String dutyPost;
    private String patrolCategory;
    private String patrolCycle;
    private LocalDate fixedDate;
    private String area;
    private String name;
    private String state;
    private String period;
    private String time;
    private String month;
    private String week;
    private String repeatPeriod;
    private String begin;
    private String end;
    private String overlock;
    private String type;
    private String unit;
    private String person;
    private String remark;
}
