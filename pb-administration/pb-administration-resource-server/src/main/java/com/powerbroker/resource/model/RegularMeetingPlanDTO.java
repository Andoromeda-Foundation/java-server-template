package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class RegularMeetingPlanDTO extends AbstractDTO {

    private String meetingName;

    private String meetingPeriod;

    private String mainContent;

    private String sponsor;
}
