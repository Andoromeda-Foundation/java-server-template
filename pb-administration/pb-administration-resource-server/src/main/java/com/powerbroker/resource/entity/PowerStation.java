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
@Table(name = "power_stations")
public class PowerStation extends AbstractEntity<Long> {

    private String identifier;
    private String fakeIdentifier;
    private String customerNo;
    private String customerName;
    private String name;
    private String comment;
    private String responseArea;
    private String industryClass;
    private Integer voltage10;
    private Integer voltage35;
    private Integer voltage110;
    private Integer voltageUnknown;
    private String capacity;
    private String phone;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String longitude;
    private String latitude;
    private Integer state;
    private Integer type;
    private Boolean detection;
    private Boolean compensation;
    private Integer configurationCount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "district_power_stations",
            joinColumns = {@JoinColumn(name = "power_station_id")},
            inverseJoinColumns = {@JoinColumn(name = "district_id")})
    private Set<District> districts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "power_station_id")
    @OrderBy("name ASC")
    private Set<PowerStationLine> powerStationLines = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private MdRequest mdRequest;
}