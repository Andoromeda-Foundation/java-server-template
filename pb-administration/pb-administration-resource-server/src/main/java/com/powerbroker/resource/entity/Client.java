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
@Table(name = "clients")
public class Client extends AbstractEntity<Long> {

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "power_station_id")
    private PowerStation powerStation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "clients_hierarchies",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "hierarchy_id")})
    private Set<Hierarchy> hierarchies = new HashSet<>(0);
}
