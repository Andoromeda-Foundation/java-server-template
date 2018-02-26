package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "navs")
public class Nav extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String icon;

    private String link;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nav")
    @OrderBy("id ASC")
    private Set<Sidebar> sidebars = new TreeSet<>();
}
