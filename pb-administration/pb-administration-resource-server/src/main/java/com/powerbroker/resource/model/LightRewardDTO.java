package com.powerbroker.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.powerbroker.common.service.IdentifierAwareDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wjwjtftf
 *         Created on 2017/1/11.
 */
@Setter
@Getter
public class LightRewardDTO implements IdentifierAwareDTO {

    private String id; // process instance id
    private LightClientDTO publishClient;
    private LightUserDTO publishUser;
    private LightStaffDTO assigner;
    private LightStaffDTO staff;
    private LightPowerStationDTO powerStation;
    private String name;
    private Boolean assigned;// 是否指定工程师处理
    private String engineerId;// 处理任务的工程师user id
    private Integer priority;
    private Integer type;
    private Integer source;
    private LocalDateTime dueAt;
    @JsonIgnore
    private String processInstanceId;
    private List<TaskDTO> task = new ArrayList<>();
    private Integer taskState;
    private String contact;
    private String phone;
    private LocalDateTime createAt;
    private LocalDateTime acceptedAt;
    private LocalDateTime departedAt;
    private LocalDateTime executedAt;
    private LocalDateTime completedAt;
    private LocalDateTime confirmedAt;
    private Boolean hasComment;
    private Boolean hasData;
}
