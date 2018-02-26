package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class PowerStationDevice extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    private Long substationId;
    private String substationName;
    private String device;
    private String deviceCategory;
    private String deviceName;
    private String accountNumber;
    private String nameplateInfo;
    private String productionInfo;
    private String superiorDevice;
    private String provider;
    private String specification;
    private String quantity;
    private String factoryNumber;
    private String factoryDate;
    private String operationDate;
    private String comments;
    private String backup1;
    private String backup2;

}
