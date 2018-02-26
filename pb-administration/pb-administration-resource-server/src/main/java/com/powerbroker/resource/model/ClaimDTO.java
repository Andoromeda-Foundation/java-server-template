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
public class ClaimDTO extends AbstractDTO {

    private String code;
    private String reason;
    private LocalDate at;
    private String place;
    private BigDecimal amount;
    private String adjuster;
    private LightInsuranceDTO insurance;
    private DocumentDTO document;
}
