package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author william
 */
@Setter
@Getter
public class UsageDTO extends AbstractDTO {

    private String reason;
    private LocalDate at;
    private String driver;
    private String company;
    private DocumentDTO document;
    private VehicleDTO vehicle;
}
