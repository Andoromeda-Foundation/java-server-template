package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class OperationRecordDTO extends AbstractDTO {

    private String operateBy;
    private String operationContent;
    private String beginTime;
    private String endTime;
}
