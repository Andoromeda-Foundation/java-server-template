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
public class DelegationDTO extends AbstractDTO {

    private String message;

    private LightPowerStationDTO powerStation;

    private LightClientDTO client;

    private LocalDateTime dueAt;

    private LocalDateTime committedAt;

    private Integer priority;

    private LocalDateTime processedAt;

    private Integer state;

    private String contact;

    private String phone;

    private LightRewardDTO reward;
}
