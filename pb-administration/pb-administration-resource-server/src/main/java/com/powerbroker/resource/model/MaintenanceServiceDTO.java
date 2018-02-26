package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class MaintenanceServiceDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String level;
    private String project;
    private String content;
    private String standard;
    private String powerCut;
    private String cycle;
    private String material;
    private Boolean extAssist;
    private String workingHours;

}
