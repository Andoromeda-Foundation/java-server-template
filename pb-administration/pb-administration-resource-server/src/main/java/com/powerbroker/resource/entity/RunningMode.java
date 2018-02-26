package com.powerbroker.resource.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.powerbroker.common.domain.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "running_modes")
public class RunningMode extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "substation_id")
    private PowerStation powerStation;

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
