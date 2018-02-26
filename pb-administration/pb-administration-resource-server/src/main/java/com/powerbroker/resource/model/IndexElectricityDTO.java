package com.powerbroker.resource.model;

import com.powerbroker.report.data.model.AbstractIndexDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author william
 */
@Setter
@Getter
public class IndexElectricityDTO extends AbstractIndexDTO {

    private BigDecimal sumHour;
    private BigDecimal sumDay;
    private BigDecimal sumMonth;

    private String key;
    private BigDecimal value;
}
