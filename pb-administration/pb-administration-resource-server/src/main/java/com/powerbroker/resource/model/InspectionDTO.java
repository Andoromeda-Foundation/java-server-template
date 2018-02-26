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
public class InspectionDTO extends AbstractDTO {

    private LocalDate at;
    private String place;
    private String submitter;
    private String consequence;
    private DocumentDTO document;
    private VehicleDTO vehicle;
}
