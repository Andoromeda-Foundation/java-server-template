package com.powerbroker.resource.model;

import com.powerbroker.report.data.model.AbstractIndexDTO;
import com.powerbroker.report.data.utils.VoltageLine;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author william
 */
@Setter
@Getter
public class IndexVoltageDTO extends AbstractIndexDTO {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal avg;
    private VoltageLine voltageLine;

    private String key;
    private BigDecimal value;
}
