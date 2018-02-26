package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class PlcMetricMetadataDTO extends AbstractDTO {

    private String node;

    private String name;

    private String metricAt;

    private String execItem;

}
