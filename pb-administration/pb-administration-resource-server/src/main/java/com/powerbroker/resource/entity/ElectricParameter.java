package com.powerbroker.resource.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "electric_parameter_record")
public class ElectricParameter extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String stationName;
    private Boolean isElectric;
    private String envHumidity;
    private String envTemperature;
    private String sfPressure1;
    private String sfPressure2;
    private String sfPressure3;
    private String transformerTemperature1;
    private String transformerTemperature2;
    private String transformerTemperature3;
    private String transformerOil1;
    private String transformerOil2;
    private String transformerOil3;
    private String switchVacuum1;
    private String switchVacuum2;
    private String switchVacuum3;
}
