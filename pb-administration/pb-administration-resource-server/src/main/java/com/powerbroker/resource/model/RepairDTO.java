package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author william
 */
@Setter
@Getter
public class RepairDTO extends AbstractDTO {

    private String reason;
    private LocalDate at;
    private String place;
    private BigDecimal amount;
    private String driver;
    private DocumentDTO document;
    private VehicleDTO vehicle;
}
