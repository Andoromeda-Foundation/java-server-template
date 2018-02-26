package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "roles")
public class Role extends AbstractEntity<Long> {

    private String name;

    private String roleType;

    private String displayName;

    private String comment;

    private Boolean admin;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_navs",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "nav_id")})
    private Set<Nav> navs = new HashSet<>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_sidebars",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "sidebar_id")})
    private Set<Sidebar> sidebars = new HashSet<>(0);
}
