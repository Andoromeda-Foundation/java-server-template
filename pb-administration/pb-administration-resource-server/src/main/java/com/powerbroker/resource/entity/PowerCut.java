package com.powerbroker.resource.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter @Getter
@Table(name ="power_cuts")
public class PowerCut extends AbstractEntity<Long>  {
	private Long substationId;
	private String customerName;
	private String substationName;
	private String transformerNo;
	private String supplyLineNo;
	private String feedLineNo;
	private String powerCutCategory;
	private String startTime;
	private String endTime;
	private String outageLoad;
	private String powerSaving;
}