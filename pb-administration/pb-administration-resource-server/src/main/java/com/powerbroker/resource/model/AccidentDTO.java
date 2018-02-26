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
public class AccidentDTO extends AbstractDTO {

    private String nature;
    private BigDecimal loss;
    private LocalDate at;
    private String place;
    private String consequence;
    private String driver;
    private DocumentDTO document;
    private VehicleDTO vehicle;
}
