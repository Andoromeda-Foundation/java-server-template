package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class LightEnterpriseDTO extends AbstractDTO {
    
    private String name;

    private String code;

    private String shortName;

    private String legalRepresentative;

    private String property;

    private String scale;

    private String remark;
}
