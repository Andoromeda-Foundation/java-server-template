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
public class MaintenanceService extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private String level;
    private String project;
    private String content;
    private String standard;
    private String powerCut;
    private String cycle;
    private String material;
    private Boolean extAssist;
    private String workingHours;

}
