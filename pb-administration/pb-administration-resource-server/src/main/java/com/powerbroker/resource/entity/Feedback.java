package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "feedbacks")
public class Feedback extends AbstractEntity<Long> {

	private String content;

	@Column(insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime submittedAt;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
}
