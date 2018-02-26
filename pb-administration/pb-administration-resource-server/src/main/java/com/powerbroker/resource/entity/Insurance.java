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
@Table(name = "insurances")
public class Insurance extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String code;
	@Column(name = "`type`")
	private String type;
	private BigDecimal amount;
	private LocalDate joinAt;
	private String entity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Vehicle vehicle;
}
