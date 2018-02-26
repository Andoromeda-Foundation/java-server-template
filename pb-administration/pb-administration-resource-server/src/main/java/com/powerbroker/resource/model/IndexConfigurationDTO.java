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
public class IndexConfigurationDTO extends AbstractIndexDTO {

    private String key;
    private BigDecimal value;
}
