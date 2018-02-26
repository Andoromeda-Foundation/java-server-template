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
@Table(name = "districts")
public class District extends AbstractEntity<Long> {

	private String name;

//	@ManyToMany(mappedBy = "districts")
//	private Set<PowerStation> powerStations = new HashSet<>(0);

//	@ManyToMany(mappedBy = "districts")
//	private Set<Staff> staffs = new HashSet<>(0);
}
