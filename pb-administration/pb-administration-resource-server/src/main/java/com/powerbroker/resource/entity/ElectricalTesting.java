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
@Table(name ="electrical_testings")
public class ElectricalTesting extends AbstractEntity<Long>  {
	@ManyToOne
	@JoinColumn(name = "station_id")
	private PowerStation powerStation;

	private String testingPeriod;
	private String tester;
	private String environmentTemperature;
	private String environmentHumidity;
	private String testingDevice;
	private String testingParam;
	private String standardParam;
	private String comment;

	private LocalDate testingTime;
	private String testingPlace;
	private String testingProject;
	private String conclusion;
	private String weather;
	private String temperature;
	private String humidity;
	private String testingPerson;
	private LocalDate reportDate;
}