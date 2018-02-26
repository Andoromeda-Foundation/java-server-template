package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "sidebars")
public class Sidebar extends AbstractEntity<Long> {

    private String name;

    private String link;

    @ManyToOne
    private Nav nav;
}
