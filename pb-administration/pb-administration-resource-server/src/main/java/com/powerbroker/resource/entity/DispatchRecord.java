package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class DispatchRecord extends AbstractEntity<Long> {

    private String customerName;
    private String stationName;
    private String inspectionItems;
    private String inspectionStandards;
    private String inspectionConfirmation;
    private String inspectionMan;
    private LocalDate inspectionDate;
    private String inspectionSituation;
    private String conclusion;

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;
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
