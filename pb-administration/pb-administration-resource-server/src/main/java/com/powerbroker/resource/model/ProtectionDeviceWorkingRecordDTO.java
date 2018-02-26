package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class ProtectionDeviceWorkingRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String deviceName;
    private String protectionFunction;
    private String actionSituation;
    private String actionTime;
    private String actionReason;
    private String description;

}
