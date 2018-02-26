package com.powerbroker.resource.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "regular_interview_plans")
public class RegularInterview extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    private Integer district;

    private Long interviewLevelId;

    private String interviewPeriod;

    @ManyToOne
    @JoinColumn(name = "responsible_department_id")
    private Dept responsibleDepart;

    private String responsiblePosition;

    private String customerName;

    private Long interviewProjectId;

}
