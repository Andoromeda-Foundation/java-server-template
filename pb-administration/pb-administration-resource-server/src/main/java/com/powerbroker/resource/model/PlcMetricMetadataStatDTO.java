package com.powerbroker.resource.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by T430 on 2017/2/4.
 */
@Setter
@Getter
public class PlcMetricMetadataStatDTO extends AbstractMethodError {

    private String time;

    private Long count;

    private Long milliseconds;
}
