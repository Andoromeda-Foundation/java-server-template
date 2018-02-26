package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class MaintenanceRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String time;
    private String personLiable;
    private String workStaff;
    private String workContent;
    private String customerAcceptance;
    private String changeFacilities;
    private String otherTips;
}
