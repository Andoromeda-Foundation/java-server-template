package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "claims")
public class Claim extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String code;
	private String reason;
	private LocalDate at;
	private String place;
	private BigDecimal amount;
	private String adjuster;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_id")
	private Insurance insurance;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private Document document;

}
