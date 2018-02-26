package com.powerbroker.resource.model;

import com.powerbroker.common.service.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author william
 */
@Setter
@Getter
public class LightRoleDTO extends AbstractDTO {

    private String name;

    private String roleType;

    private String displayName;

    private String comment;

    private Boolean admin;
}
