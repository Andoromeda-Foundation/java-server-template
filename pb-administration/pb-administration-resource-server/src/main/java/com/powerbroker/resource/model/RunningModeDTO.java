package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class RunningModeDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;

    private String area;
    private String highVoltageInlineMode;
    private String highVoltageInlineName;
    private String highVoltageBuslineName;
    private String highVoltage;
    private String lowVoltageBusline;
    private String generatorConnectingVoltage;
    private Long generatorConnectingMode;
    private String gridConnectionPoint;
    private String gridConnectionSwitchNumber;
    private String lowVoltageOutletCircuiAmount;
    private String transformerAmount;
    private String principleConnectsPictureUrl;

}
