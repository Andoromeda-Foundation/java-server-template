package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class ElectricParameterDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private Boolean isElectric;
    private String envHumidity;
    private String envTemperature;
    private String sf6Pressure1;
    private String sf6Pressure2;
    private String sf6Pressure3;
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
