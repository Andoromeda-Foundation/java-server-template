package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "attendances")
public class Attendance extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String area;

    private String clientName;

    private Long stationId;

    private String position;

    private String name;

    private String taskName;

    private String taskContent;

    private LocalDateTime taskBeginAt;

    private LocalDateTime taskEndAt;

    private LocalDateTime registerAt;

    private Long registerBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff staff;
}