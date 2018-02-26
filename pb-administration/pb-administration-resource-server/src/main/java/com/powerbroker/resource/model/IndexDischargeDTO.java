package com.powerbroker.resource.model;

import com.powerbroker.report.data.model.AbstractIndexDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class IndexDischargeDTO extends AbstractIndexDTO {

    private Integer max;
    private Integer min;
    private Integer threshold;
    private String device;

    private String key;
    private String value;
}
