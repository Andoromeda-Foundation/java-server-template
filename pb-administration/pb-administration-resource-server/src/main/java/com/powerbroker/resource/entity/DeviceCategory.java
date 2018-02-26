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
@Table(name ="device_categories")
public class DeviceCategory extends AbstractEntity<Long>  {
	private String deviceGenere;
	private String deviceCategory;
}