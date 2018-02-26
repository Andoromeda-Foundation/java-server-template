package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "event_logs")
public class EventLog extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private LocalDateTime occurredAt;

	private String content;

	@ManyToOne
	@JoinColumn(name = "power_station_id")
	private PowerStation powerStation;

	private Boolean confirmed;
}
