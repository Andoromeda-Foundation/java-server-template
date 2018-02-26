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
public class ArresterActionRecord extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private String arresterName;
    private String voltage;
    private String actionTimes;
    private String leakageCurrent;
    private String checkMan;
    private LocalDateTime checkDate;
}
