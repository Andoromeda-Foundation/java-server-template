package com.powerbroker.resource.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "regular_meeting_plans")
public class RegularMeetingPlan extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String meetingName;

	private String meetingPeriod;

	@Type(type = "text")
	private String mainContent;

	private String sponsor;
}
