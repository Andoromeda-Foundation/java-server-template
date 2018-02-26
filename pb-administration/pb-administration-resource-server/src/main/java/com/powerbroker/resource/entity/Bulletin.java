package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "bulletins")
public class Bulletin extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String title;
	private String content;
	private LocalDateTime publishedAt;
	private Integer object;
}
