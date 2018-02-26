package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class FaultRepositoryDTO extends AbstractDTO {

    private String appearance;
    private String faultDevice;
    private String faultReason;
    private String isolationMode;
    private String isolationReference;

}
