package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "regular_demand_declare_plans")
public class RegularDemandDeclarePlan extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;


    private Long distributionTransformerId;

    private LocalDate declareDate;

    private Long declareChangePeriod;

    @ManyToOne
    @JoinColumn(name = "responsible_department_id")
    private Dept responsibleDepart;


    private String responsiblePosition;

    private Long responsibleAreaId;

    private String previousMonthDemand;

    private String previousYearDemand;

    private String previousMonthDispersion;

    private String previousYearDispersion;

    private String declareDemand;

    private String distributionTransformCapacity;

    private String distributionNo;
    private String dept;
    private String district;
}