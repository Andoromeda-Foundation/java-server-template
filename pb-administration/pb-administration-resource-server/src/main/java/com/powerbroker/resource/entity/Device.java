package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author william
 */
@Entity
@Setter @Getter
@Table(name ="devices")
public class Device extends AbstractEntity<Long>  {

	@ManyToOne
	@JoinColumn(name = "power_station_id")
	private PowerStation powerStation;
	private String deviceGenere;
	private String deviceCategory;
	private String deviceName;
	private String accountNumber;
	private String nameplateInfo;
	private String superiorDevice;
	private String provider;
	private String specification;
	private String productionInfo;
	private String quantity;
	private String factoryNumber;
	private LocalDate factoryDate;
	@Transient
	private LocalDate operationDate;
	private String comment;
	private String backup1;
	private String backup2;
}