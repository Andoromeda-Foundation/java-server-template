package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "traces")
public class Trace extends AbstractEntity<Long> {

    private BigDecimal longitude;
    private BigDecimal latitude;
    private LocalDateTime committedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "rewards_traces",
            joinColumns = {@JoinColumn(name = "trace_id")},
            inverseJoinColumns = {@JoinColumn(name = "reward_id")})
    private Reward reward;
}
