package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class EventLogDTO extends AbstractDTO {

    private LocalDateTime occurredAt;
    private String content;
    private LightPowerStationDTO powerStation;
    private Boolean confirmed;
}
