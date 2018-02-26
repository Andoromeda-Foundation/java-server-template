package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class NonRunningRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String deviceName;
    private String downReason;
    private String downDuty;
    private LocalDateTime downStart;
    private LocalDateTime downEnd;
    private String terminationOrder;
    private String description;
}
