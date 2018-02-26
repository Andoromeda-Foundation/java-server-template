package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class PowerCutDTO extends AbstractDTO {

    private Long substationId;
    private String customerName;
    private String substationName;
    private String transformerNo;
    private String supplyLineNo;
    private String feedLineNo;
    private String powerCutCategory;
    private String startTime;
    private String endTime;
    private String outageLoad;
    private String powerSaving;
}
