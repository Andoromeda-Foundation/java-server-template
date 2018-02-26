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
@Setter
@Getter
@Table(name = "")
public class {{Target}} extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

}
