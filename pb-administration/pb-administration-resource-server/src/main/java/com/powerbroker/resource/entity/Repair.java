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
@Table(name = "repairs")
public class Repair extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String reason;
	private LocalDate at;
	private String place;
	private BigDecimal amount;
	private String driver;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Vehicle vehicle;

}
