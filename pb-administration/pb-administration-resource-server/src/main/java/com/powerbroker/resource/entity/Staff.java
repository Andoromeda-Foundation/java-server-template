package com.powerbroker.resource.entity;

import com.powerbroker.common.domain.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "staffs")
public class Staff extends AbstractEntity<Long> {

    private String name;
    private String no;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
    private Integer gender;
    private LocalDate birthday;
    private String idCardNo;
    private String birthplace;
    private String phone;
    private String email;
    private String remark;

    private String mobile;
    private String major;
    private LocalDate graduatedAt;
    private String title;
    private String level;
    private String workType;
    private String permission;
    private String position;
    private LocalDate enrolledAt;

//    @OneToOne(mappedBy = "staff")
//    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document avatar;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "staff_districts",
            joinColumns = {@JoinColumn(name = "staff_id")},
            inverseJoinColumns = {@JoinColumn(name = "district_id")})
    private Set<District> districts = new HashSet<>(0);
}
