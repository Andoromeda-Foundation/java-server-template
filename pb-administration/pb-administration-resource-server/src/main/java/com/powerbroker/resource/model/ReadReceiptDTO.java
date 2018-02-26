package com.powerbroker.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author william
 */
@Setter
@Getter
public class ReadReceiptDTO extends AbstractDTO {
    @JsonIgnore
    @Getter
    protected String id;
    private Boolean hasRead;
    private LocalDateTime readAt;
}
