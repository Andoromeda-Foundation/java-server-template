package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class FaultRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 945645153978382137L;

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
    @Column(name = "`desc`")
    private String desc;

    @Column(name = "`type`")
    private Integer type;

    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    @ManyToOne
    @JoinColumn(name = "power_station_line_id")
    private PowerStationLine powerStationLine;
}
