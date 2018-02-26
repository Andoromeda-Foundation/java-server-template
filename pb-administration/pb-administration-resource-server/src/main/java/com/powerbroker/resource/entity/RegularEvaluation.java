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
@Table(name = "regular_evaluations")
public class RegularEvaluation extends AbstractEntity<Long> {


	private String evaluationProject;

	private String evaluationContent;

	private String evaluationPeriod;

	private String evaluationSubject;

	private String evaluator;

	@ManyToOne
	@JoinColumn(name = "power_station_id")
	private PowerStation powerStation;
	private LocalDate evaluatedAt;
	private String state;
	private String deviceCount;
	private String finishingRate;
	private String workingScore;
	private String clientScore;
	private String allScore;
}
