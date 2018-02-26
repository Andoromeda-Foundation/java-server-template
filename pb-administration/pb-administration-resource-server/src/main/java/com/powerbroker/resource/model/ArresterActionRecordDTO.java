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
public class ArresterActionRecordDTO extends AbstractDTO {

    private String customerName;
    private String stationName;
    private String arresterName;
    private String voltage;
    private String actionTimes;
    private String leakageCurrent;
    private String checkMan;
    private LocalDateTime checkDate;

}
