package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "mds")
public class Md extends AbstractEntity<Long> {

    private BigDecimal p;
    private BigDecimal q;
    private BigDecimal value;

    private String name;
    private String node;
    private String uuid;
    private String redisKey;

    private Date metricAt;
}
