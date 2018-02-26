package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class UpdaterDTO extends AbstractDTO {

    private String name;
    private Integer version;
    private Integer forceUpdate;
    private Integer appType;
    private String updateUrl;
    private String bundleId;
}
