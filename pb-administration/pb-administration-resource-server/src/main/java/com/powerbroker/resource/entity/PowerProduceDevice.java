package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
public class PowerProduceDevice extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "substation_id")
    private PowerStation powerStation;

    private String substationName;
    private String device;
    private String deviceCategory;
    private String deviceName;
    private String accountNumber;
    private String nameplateInfo;
    private String productionInfo;
    private String specification;
    private String quantity;
    private String factoryNumber;
    private LocalDateTime factoryDate;
    private LocalDateTime operationDate;
    private String comments;
    private String backup1;
    private String backup2;
}
