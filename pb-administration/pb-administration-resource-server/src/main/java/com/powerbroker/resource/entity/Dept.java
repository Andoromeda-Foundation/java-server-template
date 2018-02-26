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
@Table(name = "depts")
public class Dept extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private String phonetic;

    private String remark;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Dept superior;

    @OneToMany(mappedBy = "superior")
    private Set<Dept> subordinates = new HashSet<>();

//    @OneToMany(mappedBy = "dept")
//    private Set<Staff> staffs = new HashSet<>();
}
