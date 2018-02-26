package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class RegularInterviewDTO extends AbstractDTO {

    private LightPowerStationDTO powerStation;

    private Integer district;

    private Long interviewLevelId;

    private String interviewPeriod;

    private String customerName;

    private Long interviewProjectId;

    private LightDeptDTO dutyDepart;

    private String responsiblePosition;


}
