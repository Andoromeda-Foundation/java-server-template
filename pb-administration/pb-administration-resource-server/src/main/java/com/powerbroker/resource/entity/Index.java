package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "indexes")
public class Index extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String identifier;
	private String name;
	private String queueName;
}
