package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "groups")
public class Group extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String path;

    @ManyToOne
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "superior_id")
    private Group superior;

    @OneToMany(mappedBy = "superior")
    private Set<Group> subordinates;
}
