package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "voltages")
public class Voltage extends AbstractEntity<Long> {

    private BigDecimal uab;
    private BigDecimal ubc;
    private BigDecimal uca;
    private BigDecimal value;
    private BigDecimal overValue;

    private String name;
    private String node;
    @Transient
    private String uuid;
    private String redisKey;

    private Date metricAt;

    @OneToMany(mappedBy = "voltage", cascade = CascadeType.ALL)
    @OrderBy("metric_at ASC")
    private Set<VoltageFault> voltageFaults = new HashSet<>();
}
