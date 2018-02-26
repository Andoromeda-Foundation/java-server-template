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
public class IndexLoadDTO extends AbstractIndexDTO {

    private BigDecimal max;
    private BigDecimal maxHour;
    private BigDecimal maxDay;
    private BigDecimal maxMonth;

    private String key;
    private BigDecimal value;
}
