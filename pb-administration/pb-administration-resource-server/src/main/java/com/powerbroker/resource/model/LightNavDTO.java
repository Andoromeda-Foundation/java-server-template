package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class LightNavDTO extends AbstractDTO {

    private String name;

    private String icon;

    private String link;
}
