package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author william
 */
@Setter
@Getter
public class ElectricalTestingDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;

    private String testingPeriod;
    private String tester;
    private String environmentTemperature;
    private String environmentHumidity;
    private String testingDevice;
    private String testingParam;
    private String standardParam;
    private String comment;

    private LocalDate testingTime;
    private String testingPlace;
    private String testingProject;
    private String conclusion;
    private String weather;
    private String temperature;
    private String humidity;
    private String testingPerson;
    private LocalDate reportDate;
}
