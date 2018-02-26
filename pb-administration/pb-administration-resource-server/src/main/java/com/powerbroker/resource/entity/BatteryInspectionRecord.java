package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class BatteryInspectionRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

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
