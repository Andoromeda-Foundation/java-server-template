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
@Table(name = "ctm_bss_customer")
public class Customer extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;
    private String customerNo;
    private String address;
    private String registCapital;
    private String corporateRepresent;
    private String industryCategory;
    private String mainBusiness;
    private String mainProduct;
    private String productCapability;
    private String upstreamProduct;
    private String downstreamIndustry;
    private String competentDepartment;
    private String productionShift;
    private String electSupervisor;
    private String electSupervisorMobile;
    private String employeeCount;
    private String contractNo;
    private String contractSubject;
    private String serviceItem;
    private String serviceContent;
    private String serviceLevel;
    private String accountManager;
    private Long employeeId;
    private String accountManagerJob;
    private String accountManagerTelephone;
    private String accountManagerMobile;
    private String accountManagerHobby;
    private String accountManagerCharacter;
    private String accountManagerAddress;
    private String electCategory;
    private String structureArea;
    private String electPriceAttr;
    private String supplyCapacity;
    private String supplyCircuit;
    private String serviceArea;
    private String supplyVoltage;
    private String supplyUnit;
    private Boolean useSelf;
    private Integer resaleNumber;
    private String resaleRelationship;
    private String resaleProperty;
    private String resaleElectCapacity;
    private String customerFocus;

}
