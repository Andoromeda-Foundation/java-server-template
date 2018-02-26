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
public class AttendanceDTO extends AbstractDTO {

    private String area;

    private String clientName;

    private Long stationId;

    private String position;

    private String name;

    private String taskName;

    private String taskContent;

    private LocalDateTime taskBeginAt;

    private LocalDateTime taskEndAt;

    private LocalDateTime registerAt;

    private Long registerBy;

    private LightStaffDTO staff;
}
