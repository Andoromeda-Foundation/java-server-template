package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class MaintenanceRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private String time;
    private String personLiable;
    private String workStaff;
    private String workContent;
    private String customerAcceptance;
    private String changeFacilities;
    private String otherTips;
}
