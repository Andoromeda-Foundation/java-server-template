package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "rfids")
public class Rfid extends AbstractEntity<Long> {

	private String identifier;

	private String deviceName;

	private String deviceType;

	private String responsible;

	@ManyToOne
	@JoinColumn(name = "power_station_id")
	private PowerStation powerStation;

	@ManyToOne
	@JoinColumn(name = "line_id")
	private PowerStationLine powerStationLine;
}
