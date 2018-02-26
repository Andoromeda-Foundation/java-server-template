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
@Table(name = "updaters")
public class Updater extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer version;
    private Integer forceUpdate;
    private Integer appType;
    private String updateUrl;
    private String bundleId;
}
