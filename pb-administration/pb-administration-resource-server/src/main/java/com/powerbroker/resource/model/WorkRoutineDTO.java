package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class WorkRoutineDTO extends AbstractDTO {

    private Long powerStationId;

    private Long areaId;

    private Long routineTypeId;

    private String workPeriod;

    private LightDeptDTO responsibleDepart;

    private String responsiblePosition;

    private Long responsibleAreaId;

    private String workContent;

    private String workRequirement;
}
