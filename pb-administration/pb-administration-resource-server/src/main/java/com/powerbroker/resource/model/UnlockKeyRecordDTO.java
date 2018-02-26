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
public class UnlockKeyRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String deviceName;
    private LocalDateTime useTime;
    private String usePerson;
    private String useReason;
    private String approvedPerson;
    private LocalDateTime returnTime;
}
