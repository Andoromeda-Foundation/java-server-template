package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class BatteryInspectionRecordDTO extends AbstractDTO {


    private String customerName;
    private String stationName;
    private String batteryName;
    private LocalDateTime measureTime;
    private String measureMan;
    private String checkMan;
    private String batteryVoltage;
    private String controlBusVoltage;
    private String chargeCurrent;
    private String batteryHealth;
}
