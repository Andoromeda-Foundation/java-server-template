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
public class LightInsuranceDTO extends AbstractDTO {

    private String code;
    private String type;
    private BigDecimal amount;
    private LocalDate joinAt;
    private String entity;
    private String principal;
}
