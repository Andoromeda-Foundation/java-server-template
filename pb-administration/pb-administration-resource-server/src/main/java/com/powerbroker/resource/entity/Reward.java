package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author wjwjtftf
 */
@Entity
@Setter
@Getter
@Table(name = "rewards")
public class Reward extends AbstractEntity<Long> {

    private String name;

    @ManyToOne
    @JoinColumn(name = "publish_client_id")
    private Client publishClient;

    @ManyToOne
    @JoinColumn(name = "publish_user_id")
    private User publishUser;

    @ManyToOne
    @JoinColumn(name = "assigner_id")
    private Staff assigner;

    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    private String processInstanceId;

    private Boolean assigned;

    private Integer priority;

    private Integer type;

    private Integer source;

    private LocalDateTime dueAt;

    private Integer taskState;

    private String contact;

    private String phone;

    @Deprecated
    private LocalDateTime processedAt;

    private LocalDateTime acceptedAt;

    private LocalDateTime departedAt;

    private LocalDateTime executedAt;

    private LocalDateTime completedAt;

    private LocalDateTime confirmedAt;

    private Boolean hasComment;

    private Boolean hasData;

    @OneToOne(mappedBy = "reward")
    private Comment comment;
}


