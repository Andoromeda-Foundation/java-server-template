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
@Table(name = "url_mappings")
public class UrlMapping extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String url;

    private String httpMethod;
}
