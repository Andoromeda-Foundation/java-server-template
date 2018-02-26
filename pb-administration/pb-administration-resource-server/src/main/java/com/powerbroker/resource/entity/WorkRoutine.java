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
@Table(name = "work_routines")
public class WorkRoutine extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long powerStationId;

	private Long areaId;

	private Long routineTypeId;

	private String workPeriod;

	@ManyToOne
	@JoinColumn(name = "responsible_department_id")
	private Dept responsibleDepart;

	private String responsiblePosition;

	private Long responsibleAreaId;

	private String workContent;

	private String workRequirement;

}
