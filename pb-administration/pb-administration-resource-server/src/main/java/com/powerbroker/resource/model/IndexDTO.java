package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class IndexDTO extends AbstractDTO {

    private String identifier;
    private String name;
    private String queueName;
}
