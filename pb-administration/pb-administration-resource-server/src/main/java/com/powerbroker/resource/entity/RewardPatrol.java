package com.powerbroker.resource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wjwjtftf
 */
@Entity
@Setter
@Getter
public class RewardPatrol extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long customerId;

	private String processInstanceId;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String ctx;
}
