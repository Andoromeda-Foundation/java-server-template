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
public class UnlockKeyRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private String deviceName;
    private LocalDateTime useTime;
    private String usePerson;
    private String useReason;
    private String approvedPerson;
    private LocalDateTime returnTime;
}
