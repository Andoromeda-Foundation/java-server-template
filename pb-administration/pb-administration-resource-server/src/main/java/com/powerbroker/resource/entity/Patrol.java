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
@Setter @Getter
@Table(name ="patrols")
public class Patrol extends AbstractEntity<Long>  {
    @ManyToOne
    @JoinColumn(name = "substation_id")
    private PowerStation powerStation;

	private String deviceCategory;

    @ManyToOne
    @JoinColumn(name = "duty_department_id")
    private Dept dutyDepart;

	private String dutyPost;
	private String patrolCategory;
	private String patrolCycle;
	private LocalDate fixedDate;
	private String area;

    private String name;
    private String state;
    private String period;
    private String time;
    private String month;
    private String week;
    private String repeatPeriod;
    private String begin;
    private String end;
    private String overlock;
    private String type;
    private String unit;
    private String person;
    private String remark;
}