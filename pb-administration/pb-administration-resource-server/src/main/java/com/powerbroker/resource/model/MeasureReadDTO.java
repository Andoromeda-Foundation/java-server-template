package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class MeasureReadDTO extends AbstractDTO {

    private String content;
    private LightRewardDTO reward;
    private LightPowerStationDTO powerStation;
    private PowerStationLineDTO powerStationLine;
}
