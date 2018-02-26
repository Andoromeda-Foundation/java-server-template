package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "measure_reads")
public class MeasureRead extends AbstractEntity<Long> {

	private String content;

	@ManyToOne
	@JoinColumn(name = "reward_id")
	private Reward reward;

	@ManyToOne
	@JoinColumn(name = "power_station_id")
	private PowerStation powerStation;

	@ManyToOne
	@JoinColumn(name = "power_station_line_id")
	private PowerStationLine powerStationLine;
}
