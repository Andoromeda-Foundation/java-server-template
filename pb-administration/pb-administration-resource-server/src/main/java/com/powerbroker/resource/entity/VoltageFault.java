package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "voltage_faults")
public class VoltageFault extends AbstractEntity<Long> {

    private BigDecimal value;
    private BigDecimal overValue;

    private Date beginAt;
    private Date endAt;

    private String name;
    private String node;

    @ManyToOne
    private Voltage voltage;
}