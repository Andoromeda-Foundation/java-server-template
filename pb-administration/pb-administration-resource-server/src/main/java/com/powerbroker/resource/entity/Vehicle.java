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
@Table(name = "vehicles")
public class Vehicle extends AbstractEntity<Long> {

    private String code;
    private String plate;
    private LocalDate purchasedAt;
    private String model;
    private String brand;
    private String license;
    private String purchaseEnterprise;
    private String purpose;
    private String fleet;
    private String principal;

    @OneToMany
    @JoinTable(name = "vehicles_gpses",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "gps_id"))
    private Set<Gps> gpses = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;
}