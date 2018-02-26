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
@Table(name = "enterprises")
public class Enterprise extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private String shortName;

    private String legalRepresentative;

    private String property;

    private String scale;

    private String remark;
}
