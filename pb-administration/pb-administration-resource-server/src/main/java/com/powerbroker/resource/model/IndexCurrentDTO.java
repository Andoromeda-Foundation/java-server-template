package com.powerbroker.resource.model;

import com.powerbroker.report.data.model.AbstractIndexDTO;
import com.powerbroker.report.data.utils.CurrentLine;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author william
 */
@Setter
@Getter
public class IndexCurrentDTO extends AbstractIndexDTO {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal avg;
    private CurrentLine currentLine;

    private String key;
    private BigDecimal value;
}
