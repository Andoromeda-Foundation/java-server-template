package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "delegations")
public class Delegation extends AbstractEntity<Long> {

    private String message;

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime dueAt;

    private LocalDateTime committedAt;

    private Integer priority;

    private LocalDateTime processedAt;

    private Integer state;

    private String contact;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;
}
