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
public class ProtectionDeviceWorkingRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private String deviceName;
    private String protectionFunction;
    private String actionSituation;
    private String actionTime;
    private String actionReason;
    private String description;

}
