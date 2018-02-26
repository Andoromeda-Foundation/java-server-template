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
@Table(name ="substation_onduty_groups")
public class SubstationOndutyGroup extends AbstractEntity<Long>  {
	private Long substationId;
	private String customerName;
	private String substationName;
	private String dutyDepartment;
	private String groupName;
	private String dutyMan;
	private String evaluationContent;
	private String remark;
}
