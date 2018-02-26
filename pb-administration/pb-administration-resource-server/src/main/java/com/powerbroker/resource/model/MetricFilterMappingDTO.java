package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class MetricFilterMappingDTO extends AbstractDTO {

    private String uuid;
    private String name;
    private String node;
    private String queueName;
    private String keys;
}
