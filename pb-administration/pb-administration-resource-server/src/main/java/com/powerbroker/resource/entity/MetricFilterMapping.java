package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "plc_metric_filter_mappings")
public class MetricFilterMapping extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String name;
	private String node;
	private String queueName;
	@Column(name="`keys`")
	private String keys;
}
